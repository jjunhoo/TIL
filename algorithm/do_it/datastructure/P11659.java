package algorithm.do_it.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class P11659 {
    /* 입력
       5 3

       5 4 3 2 1

       1 3
       2 4
       5 5
     */
    /*
       12
       9
       1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 입력 숫자 개수
        int M = scanner.nextInt(); // 출력 횟수

        int[] arr = new int[N];
        int[] result = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("[N] : " + N + " / [M] : " + M + " / ARRAY : " + Arrays.toString(arr));

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            for (int j = a; j <= b; j++) {
                if (a == b) {
                    result[i] = arr[j - 1];
                    continue;
                }
                result[i] += arr[j - 1];
            }
        }

        scanner.close();
    }
}
