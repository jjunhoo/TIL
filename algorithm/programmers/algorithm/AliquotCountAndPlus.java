package algorithm.programmers.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AliquotCountAndPlus {

    public static void main(String[] args) {
        System.out.println(solution(13, 17)); // 43
        System.out.println(solution(24, 27)); // 52
    }

    public static int solution(int left, int right) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = left; i <= right; i++) {
            // 각 수의 약수 개수 추출
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    list.add(j);
                }
            }

            // 약수 개수 추출
            hm.put(i, list.size()); // 타겟 숫자, 해당 숫자의 약수의 개수

            // list - 초기화
            list.clear();
        }

        // 짝수면 더하기 , 홀수면 빼기
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(left) % 2 == 0) { // 짝수인 경우
                answer += left;
            } else {
                answer -= left;
            }

            left++;
        }

        return answer;
    }
}
