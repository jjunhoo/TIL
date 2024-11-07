package algorithm.do_it.number_theory;

import java.util.Scanner;

// key : 에라토스테네스의 체
public class P1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        boolean[] isNotPrime = new boolean[M + 1]; // 소수 체크용 배열 (default : false)

        // 0과 1은 소수가 아니기 때문에 true
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 1. 소수로 판별된 수의 배수를 모두 지운다.
        // 2. M 까지 반복
        // - 위 과정을 반복 시, 소수만 남게 됨
        for (int i = 2; i * i <= M; i++) { // 예 : i * i => 2 - 9 - 16
            if (!isNotPrime[i]) { // 현재 i가 소수인 경우
                for (int j = i * i; j <= M; j += i) { // 해당 소수의 배수들은 소수가 아니기 때문에 true 마킹
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 0; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {  // 소수 (false 값)을 가지는 인덱스 출력
                System.out.println(i);
            }
        }
    }
}
