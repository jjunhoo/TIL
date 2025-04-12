package algorithm.codility.sieve_of_eratosthenes;

import java.util.Arrays;

/**
 * 예
 * 배열 A = [ 3, 1, 2, 3, 6 ] 일 때,
 * 각 원소 A[i]에 대해, 배열 전체에서 A[i]의 약수가 아닌 값의 개수를 카운팅
 * 결과 = [ 2, 4, 3, 2, 0 ]
 *
 * A[0] = 3 → 3의 약수는 1, 3
 * → A 배열에서 약수가 아닌 값은: [2, 6]
 * → 답: 2개
 *
 * A[1] = 1 → 1의 약수는 1
 * → A 배열에서 1의 약수가 아닌 값: [3, 2, 3, 6]
 * → 답: 4개
 *
 * A[2] = 2 → 2의 약수는 1, 2
 * → A 배열에서 약수가 아닌 값: [3, 3, 6]
 * → 답: 3개
 *
 * A[3] = 3 → 동일하게 2개 (1번과 동일)
 *
 * A[4] = 6 → 6의 약수는 1, 2, 3, 6
 * → A 배열에서 약수가 아닌 값: [ ]
 * → 답: 0개
 *
 * 핵심
 * For each A[i], count how many elements in A are not divisors of A[i].
 * 즉, ❗ A[i]의 약수가 아닌 수의 개수를 카운팅
 *
 * ❌ 3으로 x를 나눌 수 있는가? → x % 3 == 0
 * ✅ x가 3의 약수인가? → 3 % x == 0
 *
 * 문제
 *
 * You are given an array A consisting of N integers.
 *
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
 *
 * For example, consider integer N = 5 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 * For the following elements:
 *
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 *
 *
 * N개의 정수로 구성된 배열 A가 주어집니다.
 *
 * 0 ≤ i < N인 각 숫자 A[i]에 대해 A[i]의 약수가 아닌 배열 요소의 수를 세고 싶습니다.
 * 이러한 요소를 약수가 아닌 요소라고 합니다.
 *
 * 예를 들어, 정수 N = 5와 배열 A가 다음과 같다고 생각해 보겠습니다.
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 *
 * 다음 요소에 대해:
 *
 * A[0] = 3, 비약수는 2, 6입니다.
 * A[1] = 1, 비약수는 3, 2, 3, 6입니다.
 * A[2] = 2, 비약수는 3, 3, 6입니다.
 * A[3] = 3, 비약수는 2, 6입니다.
 * A[4] = 6, 비약수는 없습니다.
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int[] solution(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면, 약수가 아닌 수의 개수를 나타내는 정수 시퀀스를 반환합니다.
 *
 * 결과 배열은 정수 배열로 반환되어야 합니다.
 *
 * 예를 들어, 다음이 주어진다:
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 * 위에서 설명한 대로 함수는 [2, 4, 3, 2, 0]을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 50,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. 2 * N ] 범위 내의 정수입니다 .
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        int[] A = new int[]{ 3, 1, 2, 3, 6 };

        System.out.println(Arrays.toString(solution(A)));
    }

    public static int[] solution(int[] A) {
        int N = A.length;
        int max = Arrays.stream(A).max().getAsInt(); // A 배열의 최대값을 구해서 max에 저장 (count[] 배열 크기를 정하기 위해 필요)
        int[] count = new int[max + 1]; // x라는 숫자가 A 배열에 몇 번 등장했는지 저장하는 배열 (인덱스를 숫자로 사용)
        int[] result = new int[N]; // 정답 저장용 배열

        /**
         * A 배열을 순회하면서 각 숫자의 등장 횟수를 count[]에 누적
         * A = [3,1,2,3,6] 일 때, count[1] = 1, count[2] = 1, count[3] = 2, count[6] = 1
         */
        for (int a : A) {
            count[a]++;
        }

        for (int i = 0; i < N; i++) {
            int num = A[i]; // 현재 검사 중인 숫자
            int total = 0;

            for (int j = 1; j * j <= num; j++) { // 1부터 √num까지 num의 약수들을 찾음
                if (num % j == 0) { // j가 num의 약수인 경우에만 진행 (예: num = 6이면 → j = 1, 2, 3에서 성립)
                    int other = num / j; // 현재값의 약수 쌍이 되는 값 추출
                    total += count[j]; // 현재값 약수 카운팅

                    if (j != other) { // 현재값의 약수 쌍이 되는 값 카운팅
                        total += count[other];
                    }
                }
            }

            result[i] = N - total;
        }

        return result;
    }

    /**
     * 완전탐색
     */
    public static int[] solution2(int[] A) {
        System.out.println(Arrays.toString(A));
        int count = 0;
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] % A[j] != 0) { // 약수가 아닌 경우 카운팅
                    count++;
                }
            }

            result[i] = count;
            count = 0;
        }

        return result;
    }
}
