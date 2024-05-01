package problems.leetcode.binary;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * 참고
 * https://yunamom.tistory.com/268
 * https://engineercoding.tistory.com/168
 * https://blue-tang.tistory.com/39
 */
public class problem_371 {

    // Input: a = 1, b = 2
    // Output: 3
    public static void main(String[] args) {
        System.out.println(getSum(3, 6));
    }

    /*
     a = 3 : 0011
     b = 6 : 0110
     */
    private static int getSum(int a, int b) {
        
        while (b != 0) {
            int carry = a & b; // AND 연산
            System.out.println("carry : " + carry);

            a = a ^ b; // XOR 연산
            System.out.println("a : " + a);

            b = carry << 1; // LEFT SHIFT 연산 (비트를 왼쪽으로 1칸씩 이동하는 경우, 곱하기 2)
            System.out.println("b : " + b);
        }

        return a;
    }
}
