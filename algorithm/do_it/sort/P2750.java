package algorithm.do_it.sort;

import java.util.Arrays;
import java.util.Scanner;

/** 입력
 5
 5
 2
 3
 4
 1
 */
/** 출력
 1
 2
 3
 4
 5
 */
// 버블 정렬
public class P2750 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 입력 숫자 개수
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
