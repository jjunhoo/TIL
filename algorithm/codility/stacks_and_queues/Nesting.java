package algorithm.codility.stacks_and_queues;

/**
 * 문제
 * 시간복잡도 : O(N)
 * - 문자열 한 번 순회
 * 공간복잡도 : O(1)
 * - 상수 공간 (변수 1개 사용)
 *
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S is made only of the characters '(' and/or ')'.
 *
 *
 * N개의 문자로 구성된 문자열 S는 다음의 경우 적절하게 중첩되었다고 합니다 .
 *
 * S는 비어있습니다.
 * S는 " (U) " 형식을 갖고 있으며 여기서 U는 적절하게 중첩된 문자열입니다.
 * S는 " VW " 형식을 갖고 있는데, 여기서 V와 W는 적절히 중첩된 문자열입니다.
 * 예를 들어, 문자열 " (()(())()) "는 올바르게 중첩되었지만 문자열 " ()) "는 중첩되지 않았습니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(String S); }
 *
 * N개의 문자로 구성된 문자열 S가 주어졌을 때, 문자열 S가 적절하게 중첩되어 있으면 1을 반환하고 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, S = " (()(())()) "인 경우 함수는 1을 반환해야 하고, S = " ()) "인 경우 함수는 위에서 설명한 대로 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 1,000,000 ] 범위 내의 정수입니다 .
 * 문자열 S는 ' ( ' 및/또는 ' ) ' 문자로만 구성됩니다 .
 */
public class Nesting {
    public static void main(String[] args) {
        System.out.println(solution("(()(())())")); // 1
        System.out.println(solution("())"));        // 0
        System.out.println(solution(""));           // 1
        System.out.println(solution("("));          // 0
        System.out.println(solution(")"));          // 0
        System.out.println(solution("()"));         // 1
    }

    public static int solution(String S) {
        int count = 0;

        for (char c : S.toCharArray()) {
            if ('(' == c) {
                count++;
            } else if (')' == c) {
                count--;

                // 닫힘 괄호가 열림 괄호보다 많아지면 올바르지 않음
                if (count < 0) {
                    return 0;
                }
            }
        }

        return count == 0 ? 1 : 0;
    }
}
