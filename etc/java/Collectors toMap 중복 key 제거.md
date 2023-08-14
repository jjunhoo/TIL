## Collectors.toMap

> Stream 사용 시, 최종 연산으로 collect() 를 사용하는 경우, Stream 의 요소들을 수집하여 특정한 자료구조로 변환 가능하며, Map 으로 반환하고자 할 때, Collectors.toMap 사용

````java
List<String> strings = Arrays.asList("apple", "banana", "pear");

Map<Integer, String> map = strings.stream()
        .collect(Collectors.toMap(String::length, Function.identity()));

System.out.println(map); // 결과: {4=pear, 5=apple, 6=banana}
````

- 위 코드는 Map 에 중복 key 가 발생하게 된다면, `Duplicate key` exception 발생

````java
List<String> strings = Arrays.asList("apple", "banana", "carrot", "pear"); // key : 5, 6, 6, 4

Map<Integer, String> map = strings.stream()
        .collect(Collectors.toMap(String::length, Function.identity()));
````

````shell
// 발생 오류
Duplicate key 6 (attempted merging values banana and carrot) java.lang.IllegalStateException: Duplicate key 6 (attempted merging values banana and carrot)
````

## toMap() 시, key 의 중복을 해결 방법

- toMap() 의 다양한 시그니처
  - 3번째 파라미터로 mergeFunction 사용

````java
public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                                        Function<? super T, ? extends U> valueMapper,
                                                        BinaryOperator<U> mergeFunction) {
    // ...
}
````

## mergeFunction() 이란 ?

> a merge function, used to resolve collisions between values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction)

> mergeFunction 이란, 동일한 키로 인해 충돌(collision)이 발생했을 때, 어떤 value 를 취할 것인지 결정할 때 사용

````java
// mergeFunction 사용법
(existingValue, newValue) -> newValue;
````

> key 충돌 발생 시, 이전 value 를 새로 들어온 value 로 대체하는 코드

````java
// key : 6 의 최초 value 는 'banana' 이며, key : 6 에 매핑되어 두번째로 들어오는 value 인 'carrot' 은 'mergeFunction' 을 통해 새로 들어온 value 를 적용하기 때문에 최종값으로 'carrot' 사용
List<String> strings = Arrays.asList("apple", "banana", "carrot", "pear");

Map<Integer, String> map = strings.stream()
                               .collect(Collectors.toMap(
                                        String::length,
                                        Function.identity(),
                                        (oldVal, newVal) -> newVal
                                ));

System.out.println(map);  // {4=pear, 5=apple, 6=carrot}
````

> key 충돌 발생 시, 이전 value 를 사용하는 코드

````java
// key : 6 의 최초 value 는 'banana' 이며, key : 6 에 매핑되어 두번째로 들어오는 value 인 'carrot' 은 'mergeFunction' 을 통해 새로 들어온 value 를 무시하고, 이전 value 를 적용하기 때문에 최종값으로 'banana' 사용
List<String> strings = Arrays.asList("apple", "banana", "carrot", "pear");

Map<Integer, String> map = strings.stream()
                               .collect(Collectors.toMap(
                                        String::length,
                                        Function.identity(),
                                        (oldVal, newVal) -> oldVal
                                ));

System.out.println(map);  // {4=pear, 5=apple, 6=banana}
````

> key 충돌 발생 시, 임의의 값을 적용하는 코드

````java
List<String> strings = Arrays.asList("apple", "banana", "carrot", "pear");

Map<Integer, String> map = strings.stream()
                               .collect(Collectors.toMap(
                                        String::length,
                                        Function.identity(),
                                        (oldVal, newVal) -> "random"
                                ));

System.out.println(map);  // {4=pear, 5=apple, 6=random}
````
