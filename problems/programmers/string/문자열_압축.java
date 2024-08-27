package problems.programmers.string;

/**
 * 1. 문자열을 1부터 문자열 길이의 절반까지 자르는 단위를 늘려가며 압축
 * 2. 각 단위별로 자른 문자열을 압축했을 때의 길이 계산
 * 3. 가장 짧은 압축 길이 리턴
 */
public class 문자열_압축 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); // 예상 출력: 7
        // System.out.println(solution("ababcdcdababcdcd")); // 예상 출력: 9
        // System.out.println(solution("abcabcdede")); // 예상 출력: 8
        // System.out.println(solution("abcabcabcabcdededededede")); // 예상 출력: 14
        // System.out.println(solution("xababcdcdababcdcd")); // 예상 출력: 17
    }

    private static int solution(String s) {
        System.out.println("[solution] : " + s + " / substring test : " + s.substring(0, 4));

        int answer = s.length();

        // 1부터 문자열 길이의 절반까지의 단위로 압축을 시도
        for (int step = 1; step <= s.length() / 2; step++) {

            String compressed = "";
            String prev = s.substring(0, step);
            int count = 1;

            System.out.println("[prev] : " + prev);

            // 단위 길이 만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {

                System.out.println("[inner] j : " + j + " / j + step : " + (j + step) + " / s.substring(j, Math.min(j + step, s.length()) : " + s.substring(j, Math.min(j + step, s.length())));

                // 이전 상태와 동일하다면 압축 횟수 증가
                String sub = s.substring(j, Math.min(j + step, s.length()));
                if (prev.equals(sub)) {
                    count++;
                } else {
                    compressed += (count >= 2) ? count + prev : prev;
                    prev = sub;
                    count = 1;
                }

            }

            // 남아있는 문자열 처리
            compressed += (count >= 2) ? count + prev : prev;

            // 압축된 문자열 길이 중 최솟값 찾기
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
