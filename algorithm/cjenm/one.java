package algorithm.cjenm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 그대로
 */
public class one {

    public static final String REQUIRED = "required";
    public static final String AGREE = "agree";

    public static void main(String[] args) {
        String[] items = new String[2];
        items[0] = "(required)agreement is required";
        items[1] = "(option)agreement is option";

        String[] agreement = new String[2];
        agreement[0] = "disagree";
        agreement[1] = "agree";

        System.out.println(Arrays.toString(solution(items, agreement))); // 0

        String[] items2 = new String[4];
        items2[0] = "(required)yes i am older 19";
        items2[1] = "(required)yes i agree";
        items2[2] = "(option)i will receive advertising mail";
        items2[3] = "(required)yes i read them all";

        String[] agreement2 = new String[4];
        agreement2[0] = "agree";
        agreement2[1] = "disagree";
        agreement2[2] = "disagree";
        agreement2[3] = "disagree";

        System.out.println(Arrays.toString(solution(items2, agreement2))); // [1, 3]
    }

    private static int[] solution(String[] items, String[] agreement) {
        int[] answer;

        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < items.length ; i++) {

            boolean isRequired = false;
            StringBuilder required = new StringBuilder();

            char[] charArray = items[i].toCharArray();
            for (char c : charArray) {
                if ('(' == c) {
                    isRequired = true; // 필수/옵션 - 시작
                } else if (')' == c) {
                    isRequired = false; // 필수/옵션 - 종료
                } else {
                    if (isRequired) {
                        required.append(c);
                    }
                }
            }

            String extract = required.toString();

            if (REQUIRED.equals(extract)) {
                if (!AGREE.equals(agreement[i])) {
                    result.add(i);
                }
            }
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
