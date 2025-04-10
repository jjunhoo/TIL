package algorithm.codility.prefix_sums;

/**
 * 문제
 * - 수학적 접근
 *
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 *
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * 세 개의 정수 A, B, K가 주어졌을 때, [A..B] 범위 내에서 K로 나누어 떨어지는 정수의 개수를 반환합니다. 즉,
 *
 * { i : A ≤ i ≤ B, i  mod  K = 0 }
 *
 * 예를 들어, A = 6, B = 11, K = 2인 경우 [6..11] 범위 내에 2로 나누어 떨어지는 숫자가 6, 8, 10이라는 세 개가 있으므로 함수는 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * A와 B는 [ 0 .. 2,000,000,000 ] 범위 내의 정수입니다 .
 * K는 [ 1 .. 2,000,000,000 ] 범위 내의 정수입니다 .
 * A ≤ B.
 */
public class CountDiv {
    public static void main(String[] args) {
        // 6에서 11사이의 숫자들 중에서 2로 나누어 떨어지는 숫자의 개수
        System.out.println(solution(6, 11, 2)); // 3 (6, 8, 10)
        System.out.println(solution(10, 20, 5)); // 3 (10, 15, 20)
        System.out.println(solution(1, 1000000000, 100)); // 10000000

        System.out.println(solution2(6, 11, 2)); // 3 (6, 8, 10)
        System.out.println(solution2(10, 20, 5)); // 3 (10, 15, 20)
        System.out.println(solution2(1, 1000000000, 100)); // 10000000
    }

    /**
     * 풀이 1
     * @param A
     * @param B
     * @param K
     * @return
     */
    private static int solution(int A, int B, int K) {
        // 1. B / K는 1부터 B까지 K로 나누어 떨어지는 숫자의 개수
        // 2. A / K는 1부터 A-1까지 K로 나누어 떨어지는 숫자의 개수
        // K = 5 → {2, 4, 6, 8, 10} (1~11 중 2의 배수 개수)
        // (A - 1) / K → 5 / 2 = 2 → {2, 4} (1~5 중 2의 배수 개수)
        // 즉, 1~11의 배수 개수에서 1~5의 배수 개수를 빼면 → 5 - 2 = 3 → {6, 8, 10}
        return (B / K) - ((A - 1) / K);
    }

    /**
     * 풀이 2
     * @param start
     * @param end
     * @param divisor
     * @return
     */
    private static int solution2(int start, int end, int divisor) {
        int divisibleUpToEnd = end / divisor;
        int divisibleBeforeStart = (start - 1) / divisor;

        return divisibleUpToEnd - divisibleBeforeStart;
    }
}
