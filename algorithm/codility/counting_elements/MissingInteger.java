package algorithm.codility.counting_elements;

/**
 * 문제
 *
 * 시간복잡도
 * - 배열 2회 순회 - O(N)
 * 공간복잡도
 * - screen 배열 추가 사용 - O(N)
 *
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 *
 * 이것은 데모 작업입니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어졌을 때, A에 존재하지 않는 가장 작은 양의 정수(0보다 큰 정수)를 반환합니다.
 *
 * 예를 들어, A = [1, 3, 6, 4, 1, 2]인 경우 함수는 5를 반환해야 합니다.
 *
 * A = [1, 2, 3]인 경우 함수는 4를 반환해야 합니다.
 *
 * A = [−1, −3]인 경우 함수는 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -1,000,000 .. 1,000,000 ] 범위 내의 정수입니다 .
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));  // 출력: 5

        int[] B = {1, 2, 3};
        System.out.println(solution(B));  // 출력: 4

        int[] C = {-1, -3};
        System.out.println(solution(C));  // 출력: 1
    }

    private static int solution(int[] A) {
        int N = A.length;

        boolean[] screen = new boolean[N + 1];

        // 1부터 N까지의 수가 배열에 있는지 확인
        for (int i = 0; i < N; i++) {
            if (A[i] > 0 && A[i] <= N) {
                screen[A[i] - 1] = true;
            }
        }

        // 1부터 N까지 숫자가 존재하는지 확인
        for (int i = 0; i < N; i++) {
            if (!screen[i]) {
                return i + 1; // 빠져 있는 수 반환
            }
        }

        // 1부터 N까지 모두 존재하는 경우, N+1 반환
        return N + 1;
    }
}
