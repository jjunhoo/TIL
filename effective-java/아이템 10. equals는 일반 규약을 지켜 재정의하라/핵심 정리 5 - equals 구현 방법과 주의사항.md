## equals 는 일반 규약을 지켜 재정의하라

- == 연산자를 사용해 자기 자신의 참조인지 확인한다
- instanceof 연산자로 올바른 타입인지 확인한다
- 입력된 값을 올바른 타입으로 형변환 한다
- 입력 객체와 자기 자신의 대응되는 핵심 필드가 일치하는지 확인한다
   
   
- equals 를 재정의 할 때 hashCode 도 반드시 재정의하자 
- 너무 복잡하게 해결하지 말자
- Object 가 아닌 타입의 매개변수를 받는 equals 메소드는 선언하지 말자
  - 다른 타입을 매개변수로 받는 메소드를 작성하게 된다면, 오버라이딩이 아닌 오버로딩이 된다
  
   
- \* 구글의 'AutoValue' 또는 'Lombok' 을 사용하자
- \* IDE 의 코드 생성 기능을 사용하자

- Record - Java 17

````java
public class Point {
    private final int x;
    private final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. == 연산자를 사용해 자기 자신의 참조인지 확인
        if (this == o) {
            return true;
        }
        
        // 2. instanceof 연산자로 올바른 타입인지 확인
        if (!(o instanceof Point)) {
            return false;
        }
        
        // 3. 입력된 값을 올바른 타입으로 형변환
        Point p = (Point) o;
        
        // 4. 입력 객체와 자기 자신의 대응되는 핵심 필드가 일치하는지 확인
        // - 부동소수점을 사용하는 경우, Double, Float - 'compare' 메소드를 사용하여 비교
        // - primitive 타입을 비교하는 경우, '==' 비교 
        // - Object 를 비교하는 경우, 'equals 비교
        return p.x == x && p.y == y;
        
        // 5. null 인 경우, Objects.equals 를 사용하여 null 비교 
        // Objects.equals(null, null);
    }
    
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}

````