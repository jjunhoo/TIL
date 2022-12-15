## Value 기반 클래스

> 클래스처럼 생겼지만 int 처럼 동작하는 클래스

- 식별자가 없고 불변이다
- 식별자가 아니라 인스턴스가 가지고 있는 상태를 기반으로 equals, hashCode, toString 을 구현한다
- == 오퍼레이션이 아니라 equals 를 사용해서 동등성을 비교한다
- 동일한 (equals) 객체는 상호교환 가능하다

````java
// VO (불변)
public class Point {
    // final 
    private final int x;
    private final int y;
    
    // 식별자가 존재하면 안 됨
    // private int id; (x)
    
    // 생성자를 통해서 값 셋팅 후 불변
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}
````
