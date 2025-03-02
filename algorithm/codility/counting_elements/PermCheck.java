package algorithm.codility.counting_elements;

/**
 * 문제
 * 시간복잡도
 * - 배열 1회 순회를 통해 값 확인
 * 공간복잡도
 * - O(N) : seen 배열 추가 사용
 *
 * A non-empty array A consisting of N integers is given.
 *
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 *
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 *
 * Given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 *
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다.
 *
 * 순열 은 1부터 N까지 각 원소를 한 번씩만 포함하는 수열입니다.
 *
 * 예를 들어, 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 *
 * 순열이지만 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *
 * 값 2가 없기 때문에 순열이 아닙니다.
 *
 * 목표는 배열 A가 순열인지 확인하는 것입니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int[] A); }
 *
 * 배열 A가 주어졌을 때, 배열 A가 순열이면 1을 반환하고, 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 *
 * 함수는 1을 반환해야 합니다.
 *
 * 다음과 같은 배열 A가 주어졌습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *
 * 함수는 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 */
public class PermCheck {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2};
        System.out.println(solution(A));  // 1

        int[] B = {4, 1, 3};
        System.out.println(solution(B));  // 0
    }

    private static int solution(int[] A) {
        int N = A.length;

        // 1부터 N까지 값 확인을 위한 배열
        boolean[] screen = new boolean[N + 1];

        // 값 유효 범위 및 중복값 확인
        for (int num : A) {
            // 현재 숫자가 1부터 N 사이에 있지 않거나, 이미 존재하는 값인 경우, 순열 X
            if (num < 1 || num > N || screen[num]) {
                return 0;
            }

            screen[num] = true;
        }

        return 1;
    }
}
