package algorithm.codility.sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution(A)); // 1 (삼각형 가능)

        int[] B = {10, 50, 5, 1};
        System.out.println(solution(B)); // 0 (삼각형 불가능)

        int[] C = {3, 3, 3};
        System.out.println(solution(C)); // 1 (삼각형 가능)
    }

    public static int solution(int[] A) {
        int N = A.length;

        if (N < 3) return 0;

        Arrays.sort(A);

        for (int i = 0; i < N - 2; i++) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) { // (long) - overflow 방지
                return 1; // 삼각형 가능
            }
        }

        return 0; // 삼각형 불가능
    }
}
