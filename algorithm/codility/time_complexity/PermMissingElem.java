package algorithm.codility.time_complexity;

/**
 * 문제
 * - 등차수열을 이용한 합 계산 : sum(N) = N * (N + 1) / 2
 * - 공간복잡도
 * - 시간복잡도
 *
 *
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 *
 *
 * N개의 서로 다른 정수로 구성된 배열 A가 주어졌습니다. 배열에는 [1..(N + 1)] 범위의 정수가 포함되어 있는데, 이는 정확히 하나의 요소가 누락되었음을 의미합니다.
 *
 * 당신의 목표는 그 빠진 요소를 찾는 것입니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int[] A); }
 *
 * 배열 A가 주어졌을 때, 누락된 요소의 값을 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 *
 * 함수는 누락된 요소이므로 4를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * A의 원소는 모두 서로 다르다.
 * 배열 A의 각 요소는 [1..(N + 1)] 범위 내의 정수입니다.
 */

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 6}; // 1부터 6까지 숫자 중 4 누락
        System.out.println(solution(A));  // 4
    }

    private static int solution(int[] A) {
        int N = A.length + 1;
        int totalSum = N * (N + 1) / 2; // 등차수열을 이용한 1부터 N까지의 합
        int arraySum = 0;

        for (int num : A) {
            arraySum += num; // 배열 A 합
        }

        // 빠진 숫자는 두 합의 차이
        return totalSum - arraySum;
    }
}
