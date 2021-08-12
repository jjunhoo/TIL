# EC2 란 ?

### EC2
- EC2 : Elastic Compute Cloud
- Amazon Elastic Compute Cloud 는 안전하고, 크기 조정이 가능한 컴퓨팅 파워를 클라우드에서 제공하는 웹서비스
- 간단한 웹서비스 인터페이스를 통해 간편하게 필요한 용량을 얻고 구성 가능
- **사용한 만큼만 요금을 지불**하면 되므로, 컴퓨팅 비용 절감 가능
- 오직 Server 만 임대 (Application 직접 설치)

### EC2 가격 정책
- On-Demand : 실행하는 인스턴스에 따라 시간 또는 초당 컴퓨팅 파워로 측정된 가격 지불
    - 약정 필요 X
    - 장기적 수요 예측이 어렵거나 유연하게 EC2를 사용하고 싶은 경우

- Spot Instance : 경매 형식으로 시장에 남는 인스턴스를 저렴하게 구매해서 쓰는 방식
    - 최대 90% 정도 저렴
    - 단 언제 다시 반납해야 할지 모름
    - 시작 종료가 자유롭거나 추가적인 컴퓨팅 파워가 필요한 경우 (예: 빅데이터 분석)
    
- Reserved Instance (RI) / 예약 인스턴스 : 미리 일정 기간 (1년 ~ 3년) 약정해서 쓰는 방식
    - 최대 75% 정도 저렴
    - 수요 예측이 확실한 경우
    - 총 비용을 절감하기 위해 어느 정도 기간의 약정이 가능한 사용자
    
- Dedicated (전용 호스트) : 실제 물리적인 서버를 임대하는 방식
    - 라이센스 이슈 (Windows Server 등)
    - 규정에 따라 필요한 경우
    
### EC2 타입 종류
- 알파벳 뒤 숫자는 Generation 

[ 범용 ] 
- t3 : 저렴한 비용 (예 : 웹서버, DB)
- m5 : 범용 (예 : Application 서버)

[ 컴퓨팅 최적화 ]
- c5 : 컴퓨팅 최적화 (예 : cpu 성능이 중요한 Application / DB)
- F1 : 하드웨어 가속 (예 : 유전 연구, 금융 분석, 빅데이터 분석)

[ 메모리 최적화 ]
- r4 : 메모리 최적화 (예 : 메모리 성능이 중요한 Application / DB)
- x1e : 메모리 최적화 (예 : Spark)
- p3 : 그래픽 최적화 (예 : 머신러닝, 비트코인)

[ 저장 최적화 ]
- h1 : 디스크 Throughput 최적화 (예 : Hadoop, Map Reduce)
- i3 : 디스크 속도 최적화 (예 : NoSQL, 데이터웨어하우스)
- d2 : 디스크 최적화 (예 : 파일 서버, 데이터웨어하우스, Hadoop)

### EC2 로 Web Server 생성 실습
- EC2 만들기 
    - AMI, 타입, 세부설정, 보안그룹, 키 발급
    - 실행

- EC2 접속
    - Putty Gen 을 통한 PPK 파일 생성
    - Putty 를 통해 접속
    - FileZilla 를 통해 FTP 접속
    
- EC2 내 Web Server 설치 및 구동
    - Yum 을 통해 Apache 설치
    - Httpd 서비스 등록 
    - index.html 파일 생성
    - Public IP 를 통해 접속 

### EC2 와 다른 AWS 서비스들

###### VPC
###### Public Subnet
###### Private Subnet
###### Internet Gateway
###### ELB
###### Security Group
###### Auto Scaling Group
###### EBS 
###### AMI  
###### RDS

### EBS
- Elastic Block Store
- Block Store 의 반대 개념은 Object Store (Amazone S3 - File 단위 저장)
- Elastic Block Store (EBS) 는 AWS 클라우드의 Amazone EC2 인스턴스에 사용할 영구 블록 스토리지 볼륨을 제공한다. 각 EBS 볼륨은 가용 영역 내에 자동으로 복제되어 구성요소 장애로부터 보호해주고, 고가용성 및 내구성을 제공한다. EBS 볼륨은 워크로드 실행에 필요한 지연 시간이 짧고 일관된 성능을 제공한다. EBS 를 사용하면, 단 몇 분 내에 사용량을 많게 또는 적게 확장 할 수 있으며, 프로비저닝한 부분에 대해서만 저렴한 비용을 지불한다.
- EBS Based 
    - 반 영구적인 파일 저장 가능
    - * EBS Volume 이 네트워크로 연결되어 있음 (EC2 와 분리되어 있음)
    - 스냅샷 기능
    - 인스턴스 업그레이드 가능
    - Stop 가능
- Instance Storage 
    - 휘발성이나 빠른 방식
    - Instance Storage 가 내부에 포함되어 있음 (EC2 와 종속되어 있음)
    - 빠르지만 저장이 필요 없는 경우
    - Stop 불가


### AMI
- Amazone Machine Image
- Amazone Machine Image 는 인스턴스를 시작하는 데 필요한 정보를 제공한다. 인스턴스를 시작할 때 AMI를 지정해야 하며, 동일한 구성의 인스턴스가 여러 개 필요할 때는 한 AMI에서 여러 인스턴스를 시작할 수 있다. 서로 다른 구성의 인스턴스가 필요할 때에는 다양한 AMI를 사용하여 인스턴스를 시작하면 된다.
- AMI 는 다음을 포함한다.
    - 1개 이상의 EBS 스냅샷 또는 인스턴스 저장 지원 AMI의 경우, 인스턴스의 루트 볼륨에 대한 템플릿(예 : 운영 체제, 애플리케이션 서버, 애플리케이션)
    - AMI를 사용하여 인스턴스를 시작할 수 있는 AWS 계정을 제어하는 시작 권한
    - 시작될 때 인스턴스에 연결할 볼륨을 지정하는 블록 디바이스 매핑

### Security Group
- Security Group 은 인스턴스에 대한 인바운드 및 아웃바운드 트래픽을 제어하는 가상 방화벽 역할을 한다. VPC에서 인스턴스를 시작할 대, 최대 5개의 보안 그룹에 인스턴스를 할당할 수 있다. 보안 그룹은 서브넷 수준이 아니라 인스턴스 수준에서 작동하므로 VPC에 있는 서브넷의 각 인스턴스를 서로 다른 보안 그룹 세트에 할당할 수 있다. 시작할 떄 특정 그룹을 지정하지 않으면, 인스턴스가 자동으로 VPC의 기본 보안 그룹에 할당된다.
- 보안 장치
    - Network Access Control List(NACL) 와 함께 방화벽의 역할을 하는 서비스
- Port 허용
    - 트래픽이 지나갈 수 있는 Port 와 Source 설정 가능
    - Deny 는 불가능 (특정 포트) -> NACL 로 가능
- 인스턴스 단위 
    - 하나의 인스턴스에 하나 이상의 SG 설정 가능
    - NACL의 경우 서브넷 단위
    - 설정된 인스턴스는 설정한 모든 SG의 룰을 적용 받음
- Stateful
    - 인바운드로 들어온 트래픽은 별 다른 아웃바운드 설정 없이 나갈 수 있다.
    
### Elastic Load Balancer (ELB)
- Elastic Load Balancer 는 들어오는 어플리케이션 트래픽을 EC2 인스턴스, 컨테이너, IP 주소, Lambda 함수와 같은 여러 대상에 자동으로 분산시킨다. Elastic Load Balancer 는 단일 가용 영역 또는 여러 가용 영역에서 다양한 어플리케이션 부하를 처리할 수 있다. Elastic Load Balancer 이 제공하는 3가지 로드 밸런서는 모두 어플리케이션의 내결함성에 필요한 고가용성, 자동 확장/축소, 강력한 보안을 갖추고 있다.
- IP 가 지속적으로 바뀜
    - 지속적으로 IP가 바뀌기 때문에 도메인 기반으로 사용해야 함
- Health Check
    - 직접 트래픽을 발생시켜 인스턴스가 살아있는지를 체크함
    - In Service (서비스가 살아있는 상태), Out of Service (서비스가 죽은 상태) 두가지 상태로 나누어짐
- 3가지 종류
    - Application Load Balancer
        - Application Level (OSI 7계층 - 7계층)
    - Network Load Balancer
        - Network  Level (OSI 7계층 - 3계층)
    - Classic Load Balancer
- Sticky Session
    - 인스턴스가 여러 대 있을 때, 최초로 session 이 생성된 인스턴스로 트래픽을 보낸다.
    - ELB 에 session 정보를 쿠키로 적재 (Sticky Session 지속 시간 설정 가능)