package algorithm.do_it.datastructure;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11659
 */
public class P11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 입력 숫자 개수
        int M = scanner.nextInt(); // 출력 횟수

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = scanner.nextInt();
            arr[i] = arr[i - 1] + num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            sb.append(arr[b] - arr[a - 1]).append("\n");
        }

        scanner.close();

        System.out.println(sb);
    }
}
