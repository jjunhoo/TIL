package problems.leetcode.binary;

/**
 * https://leetcode.com/problems/number-of-1-bits
 */
public class problem_191 {
    // 'Hamming weight' : 이진 시퀀스 내의 0이 아닌 비어 있지 않은 비트의 수를 의미
    // * 입력값을 2진수로 변환한 뒤 변환된 2진수 값에 1이 몇개 포함되어 있는지 카운팅
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    /**
     * Input: n = 11 (이진수 - 1011)
     * Output: 3
     *
     * @param n
     * @return
     */
    private static int hammingWeight(int n) {
        int result = 0;

        while (n != 0) {
            result += n & 1; // 마지막 비트가 1인지 확인하여 결과에 추가
            n >>= 1; // 입력값을 오른쪽으로 1비트 시프트하여 다음 비트 확인
        }

        return result;
    }
}
