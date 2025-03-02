package algorithm.codility.time_complexity;

/**
 * 문제
 * - 부분합 (왼쪽 부분 합, 오른쪽 부분 합)
 *
 * 시간복잡도
 * - totalSum 계산 - O(N)
 *
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 *
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 *
 * For example, given:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다. 배열 A는 테이프의 숫자를 나타냅니다.
 *
 * 0 < P < N인 모든 정수 P는 이 테이프를 비어 있지 않은 두 부분 A[0], A[1], ..., A[P − 1] 및 A[P], A[P + 1], ..., A[N − 1]으로 나눕니다.
 *
 * 두 부분의 차이 는 |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|의 값입니다.
 *
 * 즉, 첫 번째 부분의 합과 두 번째 부분의 합의 절대 차이입니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 생각해 보겠습니다.
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 *
 * 이 테이프를 네 곳으로 나눌 수 있습니다.
 *
 * P = 1, 차이 = |3 − 10| = 7
 * P = 2, 차이 = |4 − 9| = 5
 * P = 3, 차이 = |6 − 7| = 1
 * P = 4, 차이 = |10 − 3| = 7
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌을 때, 얻을 수 있는 최소한의 차이를 반환합니다.
 *
 * 예를 들어, 다음이 주어진다:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 *
 * 위에서 설명한 대로 함수는 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 2 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수입니다
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        System.out.println(solution(A)); // 1
    }

    private static int solution(int[] A) {
        if (A.length < 2) {
            return 0;
        }

        // 전체 합
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int minDifference = Integer.MAX_VALUE;

        for (int element : A) {
            leftSum += element; // 왼쪽 부분 합
            rightSum -= element; // 오른쪽 부분 합 (전체 합에서 왼쪽 부분의 합을 빼면 오른쪽 부분의 합)

            int difference = Math.abs(leftSum - rightSum); // 현재 차이
            minDifference = Math.min(minDifference, difference); // 최소값 업데이트
        }

        return minDifference;
    }
}
