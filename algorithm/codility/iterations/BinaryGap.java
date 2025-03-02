package algorithm.codility.iterations;

/**
 * 문제
 * - binary 변환
 * - binary 내에서 1과 1 사이의 갭 즉, 0의 개수가 가장 많은 구간 찾기
 *
 * 시간복잡도 : O(log N)
 * - 이진 문자열 변환 - O(log N)
 * - 이진 문자열 순회하면서 가장 긴 0의 연속된 길이 탐색 - O(log N)
 * 공간복잡도 : O(log N)
 * - 이진 문자열을 저장 - O(log N)
 *
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 *
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 * The number 32 has binary representation 100000 and has no binary gaps.
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 * Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 *
 *
 * 양의 정수 N 내의 이진 갭 은 N의 이진 표현에서 양 끝이 1로 둘러싸인 연속된 0의 최대 시퀀스입니다.
 *
 * 예를 들어, 숫자 9는 이진 표현 1001을 가지고 있으며 길이 2의 이진 갭을 포함합니다.
 * 숫자 529는 이진 표현 1000010001을 가지고 있으며 길이 4와 길이 3의 두 개의 이진 갭을 포함합니다.
 * 숫자 20은 이진 표현 10100을 가지고 있으며 길이 1의 이진 갭을 하나 포함합니다.
 * 숫자 15는 이진 표현 1111을 가지고 있으며 이진 갭이 없습니다.
 * 숫자 32는 이진 표현 100000을 가지고 있으며 이진 갭이 없습니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int N); }
 *
 * 양의 정수 N이 주어지면 가장 긴 이진 갭의 길이를 반환합니다.
 * N에 이진 갭이 없으면 함수는 0을 반환해야 합니다.
 *
 * 예를 들어, N = 1041일 때 함수는 5를 반환해야 합니다.
 * N의 이진 표현은 10000010001 이고 가장 긴 이진 갭의 길이는 5이기 때문입니다.
 * N = 32일 때 함수는 0을 반환해야 합니다.
 * N의 이진 표현은 '100000'이고 이진 갭이 없기 때문입니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 2,147,483,647 ] 범위 내의 정수입니다 .
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(9)); // 2
        System.out.println(solution(529)); // 4
        System.out.println(solution(20)); // 1
        System.out.println(solution(15)); // 0
        System.out.println(solution(32)); // 0
    }

    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        for (char c : binaryString.toCharArray()) {
            if ('1' == c) {
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                }

                counting = true;
                currentGap = 0;

            } else if (counting) {
                currentGap++;
            }
        }

        return maxGap;
    }
}
