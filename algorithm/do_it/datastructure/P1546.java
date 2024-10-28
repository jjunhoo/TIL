package algorithm.do_it.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        double[] scores = new double[n];

        // 점수 입력
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextDouble();
        }

        double maxScore = Arrays.stream(scores)
                            .max()
                            .orElseThrow();

        // 새로운 평균 계산법
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += (scores[i] / maxScore) * 100;
        }

        System.out.println("[maxScore] : " + maxScore);

        // 평균
        double avg = total / n;
        System.out.printf("%.2f%n", avg);

        scanner.close();
    }
}
