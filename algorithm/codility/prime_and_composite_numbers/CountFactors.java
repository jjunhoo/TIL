package algorithm.codility.prime_and_composite_numbers;

/**
 * 문제
 *
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 *
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the number of its factors.
 *
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 *
 *
 * 양의 정수 D가 양의 정수 N의 인수가 되려면 N = D * M을 만족하는 정수 M이 존재해야 합니다.
 *
 * 예를 들어, 6은 24의 인수입니다. 왜냐하면 M = 4가 위의 조건(24 = 6 * 4)을 만족하기 때문입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int N); }
 *
 * 양의 정수 N이 주어지면, 그 인수의 개수를 반환합니다.
 *
 * 예를 들어, N = 24인 경우 함수는 8을 반환해야 합니다. 24에는 1, 2, 3, 4, 6, 8, 12, 24라는 8개의 인수가 있기 때문입니다. 24의 다른 인수는 없습니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 2,147,483,647 ] 범위 내의 정수입니다 .
 */
public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(36)); // 9
        System.out.println(solution(28)); // 6
    }

    private static int solution(int N) {
        int count = 0;
        int sqrt = (int) Math.sqrt(N);

        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                count += 2;

                if (i * i == N) { // 완전 제곱수인 경우 (예: 36 -> (6, 6))
                    count--; // 중복된 약수 하나 제거
                }
            }
        }

        return count;
    }
}
