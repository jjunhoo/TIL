package problems.leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class problem_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false; // 문자열의 길이가 다르면 아너그램 X
        }

        // 문자열을 문자 배열로 변환
        char[] str1Array = s.toCharArray();
        char[] str2Array = t.toCharArray();

        // 문자 배열 정렬
        Arrays.sort(str1Array);
        Arrays.sort(str2Array);

        // 2개의 문자 배열이 동일한 값인지 확인
        return Arrays.equals(str1Array, str2Array);
    }
}
