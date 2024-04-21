package problems.leetcode.string;

import java.util.Locale;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class problem_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("eye")); // true
        System.out.println(isPalindrome("tomato")); // false
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome(" ")); // true
    }

    /**
     * 1번째 문자부터 다음 순서대로, 끝 문자부터 안쪽으로 순서대로 비교
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {

        String replace = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT); // 영문 대소문자, 숫자 제외 미허용

        int left = 0;
        int right = replace.length() - 1;

        while (left < right) {

            if (replace.charAt(left) != replace.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
