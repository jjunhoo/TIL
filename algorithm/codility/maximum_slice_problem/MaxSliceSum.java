package algorithm.codility.maximum_slice_problem;

/**
 * 문제
 * - 카데인 알고리즘
 * - 연속된 부분합에서, 이전까지의 합이 이득이면 이어가고 손해면 버리며 최대 합을 찾는 알고리즘
 *
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
 *
 * For example, given array A such that:
 *
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 *
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000];
 * the result will be an integer within the range [−2,147,483,648..2,147,483,647].
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다. 0 ≤ P ≤ Q < N인 정수 쌍(P, Q)을 배열 A의 슬라이스 라고 합니다. 슬라이스(P, Q)의 합은 A[P] + A[P+1] + ... + A[Q]의 합계입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어졌을 때, A의 모든 슬라이스의 합 중 최대값을 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 * A[0] = 3 A[1] = 2 A[2] = -6
 * A[3] = 4 A[4] = 0
 * 이 함수는 5를 반환해야 합니다. 그 이유는 다음과 같습니다.
 *
 * (3, 4)는 합이 4인 A의 슬라이스입니다.
 * (2, 2)는 합이 -6인 A의 슬라이스입니다.
 * (0, 1)은 합이 5인 A의 슬라이스입니다.
 * A의 다른 슬라이스는 합이 (0, 1)보다 크지 않습니다.
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 1,000,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -1,000,000 .. 1,000,000 ] 범위 내의 정수입니다 .
 * 결과는 [−2,147,483,648..2,147,483,647] 범위 내의 정수가 됩니다.
 */
public class MaxSliceSum {
    public static void main(String[] args) {
        int[] A = {3, 2, -6, 4, 0};
        System.out.println(solution(A)); // 5

        int[] B = {-2, -3, -1, -5};
        // System.out.println(solution(B)); // -1 (모든 값이 음수일 때는 최대 음수 값)

        int[] C = {5, -7, 3, 5, -2, 4, -1};
        // System.out.println(solution(C)); // 10
    }

    private static int solution(int[] A) {
        // 3, 2, -6, 4, 0
        int maxEndingHere = A[0];
        int maxSoFar = A[0];

        for (int i = 1; i < A.length; i++) {
            // 현재 요소와 현재 요소 + 이전 부분 합 중 큰 값 선택
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);

            // 전체 최대 합 갱신
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
