package algorithm.do_it.datastructure;

import java.util.Scanner;

/**
 * 숫자의 합
 * https://www.acmicpc.net/problem/11720
 */
public class P11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        if (n < 1 || n > 100) {
            return;
        }

        int result = 0;

        for (char ch : s.toCharArray()) {
            result += Character.getNumericValue(ch);
        }

        System.out.println(result);
    }
}