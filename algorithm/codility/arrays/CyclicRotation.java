package algorithm.codility.arrays;

import java.util.Arrays;

/**
 * 문제
 * - 모듈러 : %
 * - 시간복잡도 : O(n)
 * - 공간복잡도 : O(n)
 *
 * An array A consisting of N integers is given.
 * Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 * the function should return [0, 0, 0]
 *
 * Given
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * the function should return [1, 2, 3, 4]
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness.
 * The performance of your solution will not be the focus of the assessment.
 *
 *
 * N개의 정수로 구성된 배열 A가 주어졌습니다.
 * 배열의 회전은 각 요소가 한 인덱스만큼 오른쪽으로 이동하고 배열의 마지막 요소가 첫 번째 자리로 이동한다는 것을 의미합니다.
 * 예를 들어, 배열 A = [3, 8, 9, 7, 6]의 회전은 [6, 3, 8, 9, 7]입니다(요소가 한 인덱스만큼 오른쪽으로 이동하고 6이 첫 번째 자리로 이동함).
 *
 * 목표는 배열을 AK번 회전하는 것입니다.
 * 즉, A의 각 요소를 오른쪽으로 K번 이동합니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * N개의 정수와 정수 K로 구성된 배열 A가 주어졌을 때, 배열 A를 K번 회전한 값을 반환합니다.
 *
 * 예를 들어, 주어진
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 *
 * 함수는 [9, 7, 6, 3, 8]을 반환해야 합니다. 세 번의 회전이 이루어졌습니다.
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *
 * 또 다른 예를 들어보면,
 *
 *     A = [0, 0, 0]
 *     K = 1
 *
 * 함수는 [0, 0, 0]을 반환해야 합니다.
 *
 * 주어진
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 *
 * 함수는 [1, 2, 3, 4]를 반환해야 합니다.
 *
 * 다음을 가정해 보겠습니다.
 *
 * N과 K는 [ 0 .. 100 ] 범위 내의 정수입니다.
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수입니다.
 * 귀하의 솔루션에서 정확성 에 초점을 맞추십시오.
 * 귀하의 솔루션의 성과는 평가의 초점이 되지 않습니다.
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] array1 = {3, 8, 9, 7, 6};
        int K1 = 3;
        System.out.println(Arrays.toString(solution(array1, K1))); // [9, 7, 6, 3, 8]

        int[] array2 = {0, 0, 0};
        int K2 = 1;
        System.out.println(Arrays.toString(solution(array2, K2))); // [0, 0, 0]

        int[] array3 = {1, 2, 3, 4};
        int K3 = 4;
        System.out.println(Arrays.toString(solution(array3, K3))); // [1, 2, 3, 4]
    }

    private static int[] solution(int[] A, int K) {
        int length = A.length;

        if (length == 0 || K % length == 0) { // A의 길이가 0이거나 K가 배열 길이의 배수인 경우, rotation 값이 동일하므로 리턴
            return A;
        }

        K = K % length; // K값이 배열 길이보다 큰 경우 처리

        int[] rotated = new int[length];

        for (int i = 0; i < length; i++) {
            int newPosition = (i + K) % length; // rotate 된 새 위치 계산
            rotated[newPosition] = A[i];
        }

        return rotated;
    }
}
