package problems.leetcode.array;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class problem_191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    // - 1과 input 값의 마지막 자리를 XOR 연산 (&) 하여 끝자리의 값이 1인지 확인
    // - 끝자리 비트가 1인 경우, result 변수에 +1
    // - 기존 이진수를 우측으로 1칸씩 모두 이동하여 다음 끝자리 비트 확인

    // input : 11
    // 1. 1011 -> 끝자리 1과 1을 AND 한 결과가 1이므로 1카운트
    // 2. 0101 -> 끝자리 1과 1을 AND 한 결과가 1이므로 1카운트
    // 3. 0010 -> 끝자리 1과 1을 AND 한 결과가 0이므로 bypass
    // 4. 0001 -> 끝자리 1과 1을 AND 한 결과가 1이므로 1카운트
    private static int hammingWeight(int n) {

        int result = 0;

        while (n != 0) {
            result += n & 1; // 마지막 비트가 1인지 확인하여 결과에 추가
            n >>= 1; // 입력값을 오른쪽으로 1비트 시프트하여 다음 비트 확인
        }

        return result;
    }

}
