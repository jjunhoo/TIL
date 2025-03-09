package algorithm.codility.euclidean;

/**
 * 문제
 * - 유클리드 호제법
 *
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
 *
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 *
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
 *
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
 *
 * You stop eating when you encounter an empty wrapper.
 *
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 *
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 *
 * Write a function:
 *
 * class Solution { public int solution(int N, int M); }
 *
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 *
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and M are integers within the range [1..1,000,000,000].
 *
 *
 * 두 개의 양의 정수 N과 M이 주어졌습니다. 정수 N은 0에서 N-1까지 번호가 매겨진 원 안에 배열된 초콜릿의 수를 나타냅니다.
 *
 * 당신은 초콜릿을 먹기 시작합니다. 초콜릿을 먹고 나면 포장지만 남습니다.
 *
 * 먼저 초콜릿 번호 0을 먹습니다. 그런 다음 원 안의 다음 M-1개 초콜릿이나 포장지를 제거하고 다음 초콜릿이나 포장지를 먹습니다.
 *
 * 더 정확하게 말하면, 만약 당신이 숫자 X의 초콜릿을 먹었다면, 당신은 다음에 숫자 (X + M)의 초콜릿을 N(나눗셈의 나머지)에 대한 모듈로로 먹게 될 것입니다.
 *
 * 빈 포장지를 보면 먹는 것을 멈춘다.
 *
 * 예를 들어, 정수 N = 10, M = 4가 주어졌을 때, 당신은 다음과 같은 초콜릿을 먹을 것입니다: 0, 4, 8, 2, 6.
 *
 * 목표는 위의 규칙에 따라 먹는 초콜릿의 개수를 세는 것입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int N, int M); }
 *
 * 두 개의 양의 정수 N과 M이 주어지면, 당신이 먹을 초콜릿의 개수를 반환합니다.
 *
 * 예를 들어, 정수 N = 10, M = 4가 주어지면 위에서 설명한 대로 함수는 5를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N과 M은 [ 1 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        System.out.println(solution(10, 4)); // 5
    }

    private static int solution(int N, int M) {
        // 초콜릿을 먹는 수 = N / GCD(N, M)
        return N / gcd(N, M);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
