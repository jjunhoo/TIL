#### EhCache

- Spring Cache의 대표 
- 동일한 요청이 들어오면 복잡한 작업을 수행해서 결과를 만드는 대신 이미 보관된 결과를 바로 돌려주는 방식 

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile3.uf.tistory.com%2Fimage%2F2457AA5058134CE00C1847">
(빨간색 박스 부분은 관리자들로 인해 최소 1분에서 최대 하루까지 같은 데이터 노출되는 영역으로 캐시해놓기 딱 좋음)

- 캐시의 경우, 모든 상황에서 쓸 수 있는 것은 아니며 아래 조건을 만족한다면 캐시 사용을 고려해보는 것이 좋음 
  1. 반복적으로 동일한 결과를 돌려주는 작업 
  2. 각 작업의 시간이 오래 걸리거나 서버에 부담을 주는 경우 (외부 API / DB 데이터 호출 등)
  
- 'spring-boot-starter-cache'는 캐시 관련 설정을 편리하게 지원해주는 패키지로 덕분에 CacheManager, EhCacheManagerFactoryBean 등의 bean 생성을
직접하지 않아도 될 수 있게 되었으며, 'spring-boot-starter-cache'는 기본 CacheManager로 ConcurrentHashMap을 사용하고 있음. EhCache를 사용하기 
위해서는 별도의 의존성 추가 작업 필요 

**CacheManagerCheck.java**
```` java 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerCheck implements CommandLineRunner { 
  private static final Logger logger = LoggerFactory.getLogger(CacheManagerCheck.class);
  private final CacheManager cacheManager;
  
  public CacheManagerCheck(CacheManager cacheManager) { 
    this.cacheManager = cacheManager;
  } 
  
  @Override
  public void run(String... strings) throws Exception {
    logger.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
  }
} 
````
- 현재 Spring boot app에서 사용중인 CacheManager가 무엇인지 확인하기 위하여 CommandLineRunner를 통해 Application 실행 시 무조건 run 메서드로
CacheManager 확인하는 코드

**ehcache.xml**
```` xml 
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
    updateCheck="false">
    <diskStore path="java.io.tmpdir" />

    <cache name="findMemberCache"
           maxEntriesLocalHeap="10000"
           maxEntriesLocalDisk="1000"
           eternal="false"
           diskSpoolBufferSizeMB="20"
           timeToIdleSeconds="300" timeToLiveSeconds="600"
           memoryStoreEvictionPolicy="LFU"
           transactionalMode="off">
        <persistence strategy="localTempSwap" />
    </cache>

</ehcache>
````
- 위 캐시 설정 xml 파일에서 가장 중요한 부분은 캐시 이름인 'findMemberCache'으로 내가 캐시하고 싶은 메서드에 'findMemberCache'를 지정하면 설정이 적용됨

**Application.java**
````java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication 
@EnableCaching  // Annotation을 사용하여 Cache 기능 활성화
@Controller
public class Application {
  private static Logger logger = LoggerFactory.getLogger(Application.class);
  
  @Autowired
  MemberRepository memberRepository
  
  @GetMapping("/member/nocache/{name}")
  @ResponseBody
  public Member getNoCacheMember(@PathVariable String name) {
    long start = System.currentTimeMillis();                // 수행시간 측정 
    Member member = memberRepository.findByNameCache(name); // DB 조회 
    long end   = System.currentTimeMillis();
    
    logger.info(name+ "의 NoCache 수행시간 : "+ Long.toString(end-start));    
    
    return member;
  }
  
  @GetMapping("/member/cache/{name}")
  @ResponseBody
  public Member getCacheMember(@PathVariable String name) {  
    long start = System.currentTimeMillis();                // 수행시간 측정 
    Member member = memberRepository.findByNameCache(name); // DB 조회 
    long end   = System.currentTimeMillis();
    
    logger.info(name+ "의 Cache 수행시간 : "+ Long.toString(end-start));    
    
    return member;
  }
  
  @GetMapping('/member/refresh/{name}')
  @ResponseBody
  public String refresh(@PathVariable String name) {
    memberRepository.refresh(name); // 캐시 제거 
    return "cache clear!";
  }
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  } 
  
  @GetMapping("/")
  @ResponseBody
  public String index() {
    return "Hello world";
  }
}
````


**MemberRepositoryImpl**
```` java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
  private static Logger logger = LoggerFactory.getLogger(MemberRepositoryImpl.class);

  @Override
  public Member findByNameNoCache(String name) { 
    slowQuery(2000); 
    return new Member(0, name + "@gmail.com", name);
  }
  
  @Override
  @Cacheable(value="findMemberCache", key="#name")
  public Member findByNameCache(String name) { 
    slowQuery(2000);
    return new Member(0, name + "@gmail.com", name);
  }
  
  @Override
  @CacheEvict(value = "findMemberCache", key="#name")
  public void refresh(String name) { 
    logger.info(name + " Cache clear ! ");
  }
  
  // Big Query 실행 가정 
  private void slowQuery(long seconds) { 
    try {
      Thread.sleep(seconds);
    } catch(InterruptedException e) { 
      throw new IllegalStateException(e);
    }
  }
}
````
**@Cacheable(value="findMemberCache", key="#name")**
- ehcache.xml에서 지정한 'findMemberCache' 캐시를 사용하겠다는 의미이며, key는 메소드 argument인 name을 사용하겠다는 의미 (즉 name에 따라 별도 캐시)
- 'findByNameCache'메소드의 argument에 따라 캐시되기 때문에 name이 'TestName1', 'TestName2'

