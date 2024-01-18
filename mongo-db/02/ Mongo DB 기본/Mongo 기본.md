## Mongo DB 기본

### 1. Mongo DB 기본 개념

- Mongo DB 데이터의 기본 단위는 도큐먼트이고 이는 관계형 데이터베이스의 행과 유사하지만 더 강력
- 같은 맥락에서 Mongo DB의 컬렉션은 동적 스키마가 있는 RDB 테이블과 같음
- Mongo DB 단일 인스턴스는 자체적인 컬렉션을 갖는 여러 개의 독립적인 데이터베이스를 호스팅
- 모든 도큐먼트는 컬렉션 내에서 고유한 특수키인 `_id` 를 가진다
- Mongo DB는 `Mongo Shell` 이라는 간단하지만 강력한 도구와 함께 배포된다
  - Mongo Shell 은 Mongo DB 인스턴스를 관리하고 Mongo DB 쿼리 언어로 데이터를 조작하기 위한 내장 지원을 제공

### 2. 도큐먼트

- Mongo DB의 핵심
  - 정렬된 key 와 연결된 값으로 이뤄진 도큐먼트

````json
// "greeting" 이라는 key 에 "Hello, world!" 라는 값을 가진 도큐먼트
{ "greeting": "Hello, world!" }

// "greeting" 이라는 key 에 "Hello, world!" 라는 값을 갖고 "view" 라는 key 에 3이라는 값을 가진 도큐먼트
{ "greeting": "Hello, world!", "view" : 3 }
````

- 도큐먼트의 key 는 문자열이며, 다음 예외 몇가지를 제외하면 어떤 UTF-8 문자든 사용 가능

  - 키는 `\0(null)`을 포함하지 않는다 `\0` 은 키의 끝을 나타내는 데 사용
  - `.`과 `$`문자는 몇가지 특별한 속성을 가지며 특정 상황에서만 사용해야 한다. 이들은 `예약어`이기 떄문에 부적절하게 사용하면 드라이버에서 경고 발생
- Mongo DB는 `데이터형`과 `대소문자` 구별
- Mongo DB 에서 key 중복 불가능

````json
// 데이터형
{"count": 5}
{"count": "5"}

// 대소문자
{"count": 5}
{"Count": 5}
````
