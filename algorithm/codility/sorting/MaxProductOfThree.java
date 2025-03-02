package algorithm.codility.sorting;

import java.util.Arrays;

/**
 * 문제
 * - 정렬을 활용 큰 숫자들 조합 (음수 처리 포인트)
 * - 케이스
 * -- 1. 양수 3개의 곱
 * -- 2. 음수 2개 + 가장 큰 양수의 곱 → 음수 × 음수는 양수
 *       => [-10, -2, 1, 3, 5]
 *       => 최대곱 : (-10) * (-2) * 5 = 100
 *
 * A non-empty array A consisting of N integers is given.
 * The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 *
 * For example, array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 *
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 *
 * For example, given array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다. 삼중항 (P, Q, R)의 곱은 A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N)과 같습니다.
 *
 * 예를 들어, 배열 A는 다음과 같습니다.
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * 다음 예제 삼중항을 포함합니다:
 *
 * (0, 1, 2) 곱은 −3 * 1 * 2 = −6입니다.
 * (1, 2, 4) 곱은 1 * 2 * 5 = 10 입니다.
 * (2, 4, 5) 곱은 2 * 5 * 6 = 60입니다.
 * 여러분의 목표는 모든 삼중항의 최대곱을 찾는 것입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * 비어 있지 않은 배열 A가 주어지면, 모든 삼중항의 최대곱 값을 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 *
 * 함수는 삼중항 (2, 4, 5)의 곱이 최대이므로 60을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 3 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수입니다.
 */
public class MaxProductOfThree {
    public static void main(String[] args) {

    }

    private static int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;

        int max1 = A[N - 1] * A[N - 2] * A[N - 3]; // 가장 큰 3개 수 양수 곱
        int max2 = A[0] * A[1] * A[N - 1]; // 가장 작은 2개(음수) 수와 가장 큰 양수 곱

        // 최대값 반환
        return Math.max(max1, max2);
    }
}
