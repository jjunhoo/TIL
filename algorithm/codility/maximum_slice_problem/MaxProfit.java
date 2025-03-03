package algorithm.codility.maximum_slice_problem;

/**
 * 문제
 * - 최소값을 찾고 그 이후에 나오는 최대 이익 계산
 * 시간복잡도
 * - O(N)
 * 공간복잡도
 * - O(1)
 *
 * An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 *
 * For example, consider the following array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
 *
 * Write a function,
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
 *
 * For example, given array A consisting of six elements such that:
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * the function should return 356, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 *
 *
 * N개의 정수로 구성된 배열 A가 주어집니다.
 * 여기에는 N일 연속 기간 동안 주식의 일일 가격이 포함되어 있습니다.
 * 0 ≤ P ≤ Q < N인 P일에 단일 주식을 매수하고 Q일에 매도한 경우 이러한 거래의 이익은 A[Q] ≥ A[P]인 경우 A[Q] − A[P]와 같습니다.
 * 그렇지 않은 경우 이 거래는 A[P] − A[Q]의 손실을 초래합니다.
 *
 * 예를 들어, 다음과 같은 6개의 요소로 구성된 배열 A를 생각해 보겠습니다.
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 *
 * 주식을 0일에 매수하고 2일에 매도하면 A[2] − A[0] = 21123 − 23171 = −2048이므로 2048의 손실이 발생합니다. 주식을 4일에 매수하고 5일에 매도하면 A[5] − A[4] = 21367 − 21013 = 354이므로 354의 이익이 발생합니다. 가능한 최대 이익은 356입니다. 주식을 1일에 매수하고 5일에 매도하면 발생합니다.
 *
 * 함수를 작성하세요.
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면, N일 연속 기간 동안 주식의 일일 가격이 포함되어 있고, 이 기간 동안 한 거래에서 가능한 최대 이익을 반환합니다.
 * 이 함수는 이익을 얻을 수 없는 경우 0을 반환해야 합니다.
 *
 * 예를 들어, 다음과 같은 6개의 요소로 구성된 배열 A가 주어졌습니다.
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 *
 * 위에서 설명한 대로 함수는 356을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 400,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 0 .. 200,000 ] 범위 내의 정수입니다 .
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A)); // 356
    }

    private static int solution(int[] A) {
        int N = A.length;

        if (N == 0) {
            return 0;
        }

        int minPrice = A[0]; // 최소 가격을 1번째 가격으로 초기화
        int maxProfit = 0; // 최대 이익 0으로 초기화

        for (int i = 1; i < N; i++) {
            int profit = A[i] - minPrice; // 현재 가격 - 최소 가격

            // 최대 이익 갱신
            maxProfit = Math.max(maxProfit, profit);

            // 최소 가격 갱신
            minPrice = Math.min(minPrice, A[i]);
        }

        return maxProfit;
    }
}
