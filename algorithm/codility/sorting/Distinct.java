package algorithm.codility.sorting;

import java.util.HashSet;

/**
 * 문제
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 *
 * For example, given array A consisting of six elements such that:
 *
 *  A[0] = 2    A[1] = 1    A[2] = 1
 *  A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 *
 * 함수를 작성하세요
 *
 * class Solution { public int solution(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어졌을 때, 배열 A에 있는 고유한 값의 개수를 반환합니다.
 *
 * 예를 들어, 다음과 같은 6개의 요소로 구성된 배열 A가 주어졌습니다.
 *
 * A[0] = 2 A[1] = 1 A[2] = 1
 * A[3] = 2 A[4] = 3 A[5] = 1
 *
 * 배열 A에 1, 2, 3이라는 3개의 고유한 값이 나타나므로 함수는 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -1,000,000 .. 1,000,000 ] 범위 내의 정수입니다 .
 */
public class Distinct {
    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(A)); // 출력: 3

        int[] B = {1, 2, 3, 4, 5};
        System.out.println(solution(B)); // 출력: 5

        int[] C = {1, 1, 1, 1, 1};
        System.out.println(solution(C)); // 출력: 1
    }

    private static int solution(int[] A) {
        HashSet<Integer> uniqueValues = new HashSet<>();

        for (int num : A) {
            uniqueValues.add(num);
        }

        return uniqueValues.size();
    }
}
