package algorithm.codility.stacks_and_queues;

import java.util.Stack;

/**
 * 문제
 *
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 *
 *
 * 다음 조건 중 하나라도 참이면 N개의 문자로 구성된 문자열 S는 적절하게 중첩된 것으로 간주됩니다.
 *
 * S는 비어있습니다.
 * S는 " (U) " 또는 " [U] " 또는 " {U} " 형식을 가지며 여기서 U는 적절하게 중첩된 문자열입니다.
 * S는 " VW " 형식을 갖고 있는데, 여기서 V와 W는 적절히 중첩된 문자열입니다.
 * 예를 들어, 문자열 " {[()()]} "는 적절하게 중첩되었지만 " ([)()] "는 중첩되지 않았습니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(String S); }
 *
 * N개의 문자로 구성된 문자열 S가 주어졌을 때, S가 적절하게 중첩되어 있으면 1을 반환하고 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, S = " {[()()]} "인 경우 함수는 1을 반환해야 하고 S = " ([)()] "인 경우 함수는 위에서 설명한 대로 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 200,000 ] 범위 내의 정수입니다 .
 * 문자열 S는 다음 문자로만 구성됩니다: ' ( ', ' { ', ' [ ', ' ] ', ' } ' 및/또는 ' ) '.
 */
public class Brackets {
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}")); // 1 (올바른 문자열)
        System.out.println(solution("([)()]"));   // 0 (올바르지 않은 문자열)
        System.out.println(solution(""));         // 1 (빈 문자열은 올바름)
        System.out.println(solution("()"));       // 1 (올바른 문자열)
        System.out.println(solution("({[})]"));   // 0 (열고 닫은 순서 불일치)
    }

    private static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if ('(' == ch || '{' == ch || '[' == ch) { // 여는 괄호는 스택에 push
                stack.push(ch);
            } else {
                if (stack.isEmpty()) { // 닫는 괄호가 나왔는데 스택이 비어있으면 실패
                    return 0;
                }

                char top = stack.pop(); // 스택에서 pop

                // 괄호 짝이 맞는지 확인
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return 0;
                }
            }
        }

        // 스택이 비어있어야 올바른 문자열
        return stack.isEmpty() ? 1 : 0;
    }
}
