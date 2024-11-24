package algorithm.do_it.number_theory;

import java.util.Scanner;

/**
 * [ 약수의 대칭적 특성 ]
 * 어떤 수 num 의 약수는 대칭적으로 쌍을 이룬다.
 *
 * 예를 들어 36의 약수는 (1, 36), (2, 18), (3, 12), (4, 9), (6, 6)
 * -> 1, 2, 3, 4, 6
 * 이 쌍들을 보면 *어떤 두 약수의 곱이 항상 num* 이 되는 것을 알 수 있습니다.
 * 이런 특성 때문에 어떤 약수의 쌍에서 작은 약수는 항상 √num 이하에 있습니다.
 * 예를 들어, num = 36이라면, √36 = 6이고, 6 이하의 수들만 확인해도 충분합니다. 그 이상의 약수는 이미 쌍으로 처리되었기 때문입니다.
 */
public class P1747 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (true) {

            if (isPrime(number) && isPalindrome(String.valueOf(number))) {
                System.out.println(number);
                break;
            }

            number++;
        }
    }

    /**
     * 소수 여부
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지는 경우, 소수 X
            }
        }

        return true;
    }

    /**
     * 펠린드롬 여부 리턴
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }
}
