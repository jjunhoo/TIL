package problems.leetcode.etc;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class problem_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    private static boolean isPalindrome(int x) {

        char[] arr = String.valueOf(x).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return Boolean.FALSE;
            }
        }


        return Boolean.TRUE;
    }
}
