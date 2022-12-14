## 핵심 정리 2 - equals 규약 - 반사성, 대칭성

> 핵심 정리 : equals 규약

- 반사성 : A.equals(A) == true
- 대칭성 : A.equals(B) == B.equals(A)
  - CaseInsensitiveString
- 추이성 : A.equals(B) && B.equals(C), A.equals(C)
  - Point, ColorPoint(inherit), CounterPointer, ColorPoint(comp)
- 일관성 : A.equals(B) == A.equals(B)
- null-아님 : A.equals(null) == false


````java
// 대칭성
public class CaseInsensitiveString {
    
    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    
    // 대칭성 위배
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        
        if (o instanceof String) { // 한쪽 방향으로만 작동 (CaseInsensitiveString 타입이 아닌 String 타입을 추가로 지원하기 때문)
            return s.eqaulsIgnoreCase((String) o);
        }
        
        return false;
    }

    /* 대칭성을 고려한 equals 메소드 (CaseInsensitiveString 타입만 비교)
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
    */

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String polish = "polish";
        System.out.println(cis.equals(polish)); // true
        System.out.println(polish.equals(cis)); // false
      
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(polish)); // false
    }
}
````

> Java 의 대칭성 위배 코드 
````java
public class EqualsInJava extends Object {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time); // Date 클래스 상속
        Date date = new Date(time);
        
        // 대칭성 위배
        System.out.println(date.equals(timestamp)); // true
        System.out.println(timestamp.equals(date)); // false
    }
}
````
