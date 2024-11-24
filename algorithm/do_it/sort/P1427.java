package algorithm.do_it.sort;

import java.util.Arrays;
import java.util.Scanner;

/** 입력
2143
 */
/** 출력
4321
 */
// 선택 정렬
public class P1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();
        int[] num = new int[arr.length];

        // int 배열 선언 및 저장
        for (int i = 0; i < arr.length; i++) {
            num[i] = Character.getNumericValue(arr[i]);
        }

        // 선택 정렬
        for (int i = 0; i < arr.length; i++) {
            int max = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (num[j] > num[max]) {
                    max = j;
                }
            }

            if (num[i] < num[max]) {
                int temp = num[max];
                num[max] = num[i];
                num[i] = temp;
            }
        }

        System.out.println(Arrays.toString(num));
    }
}
