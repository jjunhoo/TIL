package algorithm.cjenm;

/**
 * 전광판
 *
 * 글자 N개를 보여주는 전광판
 * 이 전광판에 글자를 오른쪽에서 왼쪽으로 반복해 흘러가게 만들려함
 *
 * 예를 들어 6글자를 표시할 수 있는 전광판에 "hi bye" 작성 시 아래와 같음
 *
 * n    text        second      result
 * 6    "hi bye"    1           "_____h"
 * 6    "hi bye"    2           "____hi"
 * 6    "hi bye"    6           "hi_bye"
 * 6    "hi bye"    11          "e_____"
 * 6    "hi bye"    12          "______"
 * 6    "hi bye"    13          "_____h"
 *
 * 6 % 1 = 1
 */
public class two {
    public static void main(String[] args) {
        System.out.println(solution(6, "hi bye", 1));   // _____h

        /*
        System.out.println(solution(6, "hi bye", 2));   // ____hi
        System.out.println(solution(6, "hi bye", 6));   // hi_bye
        System.out.println(solution(6, "hi bye", 11));  // e_____
        System.out.println(solution(6, "hi bye", 12));  // ______
        System.out.println(solution(6, "hi bye", 13));  // _____h
        */
    }

    private static String solution(int n, String text, int second) {
        // 스크롤 대상 문자열: 앞뒤에 언더스코어로 빈 화면을 만들어 줌
        String padded = "_".repeat(n) + text + "_".repeat(n); // ______hi bye______
        int start = second % (text.length() + n);

        return padded.substring(start, start + n);
    }
}
