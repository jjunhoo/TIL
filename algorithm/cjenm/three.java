package algorithm.cjenm;

import java.util.Arrays;

/**
 * 배열 섞기
 1번 스텝 -  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 (1개 배열)

 2번 스텝 - 1, 3, 5, 7, 9, 11, 2, 4, 6, 8, 10, 12 (2개 배열)

 3번 스텝 - 1, 5, 9, 3, 7, 11, 2, 6, 10, 4, 8, 12 (4개 배열)

 결과 - 1, 5, 9, 3, 7, 11, 2, 6, 10, 4, 8, 12 (각 원소)
 *
 * n       result
 * 12      [1, 5, 9, 3, 7, 11, 2, 6, 10, 4, 8, 12]
 * 18      [1, 7, 13, 3, 9, 15, 5, 11, 17, 2, 8, 14, 4, 10, 16, 6, 12, 18]
 *
 */
public class three {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12)));
        System.out.println(Arrays.toString(solution(18)));
    }

    private static int[] solution(int n) {
        // 초기 배열 생성 [1,2,3,4,5,6,7,8,9,10,11,12]
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // 2개 그룹으로 나누기
        int[] step1 = new int[n];
        int idx = 0;

        // 첫 번째 그룹 (1,3,5,7,9,11)
        for (int i = 0; i < n; i += 2) {
            step1[idx++] = arr[i];
        }
        // 두 번째 그룹 (2,4,6,8,10,12)
        for (int i = 1; i < n; i += 2) {
            step1[idx++] = arr[i];
        }

        // 4개 그룹으로 나누기
        int[] result = new int[n];
        idx = 0;
        int groupSize = n / 4;

        // 4개의 그룹으로 나누어 재배열
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < n; j += 4) {
                result[idx++] = step1[j];
            }
        }

        return result;

    }


    /*
    private static int[] solution(int n) {
        int[] answer = {};

        return answer;
    }
    */
}
