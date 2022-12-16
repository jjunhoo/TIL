````java
// 추이성 (A == B -> B == C -> A == C)
public class Point { // 불변 2차원 정수 점 (Point) 클래스
    private final int x;
    private final int y;
    
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

public enum Color { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

// Point 에 값 컴포넌트 (Color) 추가
public class ColorPoint extends Point {
    private final Color color;
    
    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    
    // 잘못된 코드 - 대칭성 위배
    /*
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
    */

    // 잘못된 코드 - 추이성 위배
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        
        // o 가 일반 Point 면 색상을 무시하고 비교
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }
        
        // o 가 ColorPoint 면 색상까지 비교
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        // 첫 번째 equals 메소드는 '대칭성' 위배 
        // - Point 가 기준이 될 경우, Point == ColorPoint 가 성립하지만, ColorPoint 가 기준이 될 경우, ColorPoint -> Point 이기 때문 
        /*
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p)); // true, false
        */
        
        // 두 번째 equals 메소드는 '추이성' 위배
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println("%s %s %s%n", p1.eqauls(p2), p2.equals(p3), p1.equals(p3)); // true, true, false
        
    }
}
````

````java
// equals 규약을 지키면서 값 추가하기 (Composition 사용)
public class Point {
    private final int x;
    private final int y;
    
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

public enum Color { 
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET 
}

public class ColorPoint {
    // * Composition - 상속 받는 것이 아니라 필드로 추가
    private final Point point;
    private final Color color;
    
    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    // 해당 ColorPoint 의 Point 뷰 반환
    public Point asPoint() {
        return point;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. 타입 비교
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        
        ColorPoint cp = (ColorPoint) o;
        // 필드 값 비교 (Point, Color)
        return cp.point.equals(point) && cp.color.equals(color);
    }
    
    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }

}

public class CounterPointTest {
    
    private static final Set<Point> unitCircle = Set.of(
            new Point(1,  0), new Point(0, 1),
            new Point(-1, 0), new Point(0, -1)
    );
    
    private static boolean onUintCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new ColorPoint(1, 0, Color.RED).asPoint();
        
        System.out.println(onUintCircle(p1)); // true
        System.out.println(onUintCircle(p2)); // true
    }
    
}
````
