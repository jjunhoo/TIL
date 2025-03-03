package algorithm.codility.sieve_of_eratosthenes;

/**
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

    }
}
