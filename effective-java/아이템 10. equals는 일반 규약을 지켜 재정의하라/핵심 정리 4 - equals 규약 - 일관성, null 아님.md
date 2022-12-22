> 일관성의 경우, 가변 객체는 항상 같을 수 없지만 불변 객체의 경우 항상 같아야 한다

````java
// URL 클래스의 경우, 최종적으로는 도메인이 가리키는 IP를 기준으로 비교하기 때문에, 일관성이 보장되지 않을 수 있음
public class EqualsInJava extends Object {
    public static void main(String[] args) {
        // 최종 도메인 네임이 가리키는 IP 가 다른 경우, false 
        URL google1 = new URL("https", "about.google", "/products");
        URL google2 = new URL("https", "about.google", "/products");
        System.out.println(google1.equals(google2)); // true
    }
}
````