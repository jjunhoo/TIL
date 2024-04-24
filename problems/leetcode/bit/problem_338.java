package problems.leetcode.bit;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class problem_338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2))); // [0, 1, 1]
        System.out.println(Arrays.toString(countBits(5))); // [0, 1, 1, 2, 1, 2]
    }

    /**
     * 이진수 변환 및 1의 개수 카운팅
     *
     * @param n
     * @return
     */
    private static int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            result[i] = countOnesInBinary(i);
        }

        return result;
    }
    
    private static int countOnesInBinary(int num) {

        int count = 0;

        while (num > 0) {
            count += num & 1; // AND 계산을 통해 맨우측 비트 1여부 확인
            num >>= 1; // 우측 시프트로 다음 비트 확인
        }

        return count;
    }
}
