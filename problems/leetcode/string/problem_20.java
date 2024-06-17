package problems.leetcode.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class problem_20 {
    public static void main(String[] args) {
        System.out.println(valid("([)]"));
    }

    /**
     * 1. case
     * - Input: s = "()"
     * - Output: true
     *
     * 2. case
     * - Input: s = "()[]{}"
     * - Output: true
     *
     * 3. case
     * - Input: s = "(]"
     * - Output: false
     */
    private static boolean valid(String str) {
        char[] arr = str.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char ch : arr) {

            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
