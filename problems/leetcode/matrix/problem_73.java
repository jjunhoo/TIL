package problems.leetcode.matrix;

import java.util.Arrays;

public class problem_73 {
  public static void main(String[] args) {
        // int[][] matrix = { {1,1,1}, {1,0,1}, {1,1,1} };
        int[][] matrix = { {0,1,2,0}, {3,4,5,2}, {1,3,1,5} };

        // setZeroes(matrix);
        setZeroes2(matrix);
    }

    /**
     * 주어진 행렬에서 0이 위치한 곳의 행과 열 모든 값을 0으로 치환
     * - 전체 행렬을 탐색하며 0이 발견되다면 그 위치에 해당하는 첫번째 행과 열 값 저장 및 0으로 치환
     *
     * case 1.
     * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * Output: [[1,0,1],[0,0,0],[1,0,1]]
     *
     * case 2.
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     * @param matrix
     */
    // solution 1.
    public static void setZeroes(int[][] matrix) {

        System.out.println("[Before] setZeroes : " + Arrays.deepToString(matrix));

        // matrix - row, col
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 첫번째 행, 열 '0' 존재 여부
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        // 1. 첫번째 행과 첫번째 열에 '0' 존재 여부 확인
        for (int j = 0; j < cols; j++) {
            if (0 == matrix[0][j]) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (0 == matrix[i][0]) {
                isFirstColZero = true;
                break;
            }
        }

        // 2. * 2번째 행, 2번째 열부터 '0' 존재 여부 확인
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) { // '0' 존재 여부 확인
                    matrix[i][0] = 0; // 첫번째 행을 '0' 으로 `마킹`
                    matrix[0][j] = 0; // 첫번째 열을 '0' 으로 `마킹`
                }
            }
        }

        // 3. * 2단계에서 확인한 결과를 기준으로 첫번째 행,열이 '0' 으로 셋팅된 경우, 해당 위치 '0' 셋팅
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // 2번 단계에서 마킹해놓은 첫번째 행, 첫번째 열의 값 확인 후  모두 '0' 처리
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 1번에서 확인한 첫번째 행 '0' 존재 여부가 true 인 경우, 첫번째 행 모두 '0' 처리
        if (isFirstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 5. 1번에서 확인한 첫번째 열 '0' 존재 여부가 true 인 경우, 첫번째 열 모두 '0' 처리
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }


        System.out.println("[After] setZeroes : " + Arrays.deepToString(matrix));
    }

    // solution 2.
    public static void setZeroes2(int[][] matrix) {

        System.out.println("[Before] setZeroes : " + Arrays.deepToString(matrix));

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // 1. 각 행과 열에 '0' 존재 여부 확인
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 2. 마킹한 행을 '0' 으로 설정
        for (int i = 0; i < rows; i++) {
            if (row[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 3. 마킹한 열을 '0' 으로 설정
        for (int j = 0; j < cols; j++) {
            if (col[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("[After] setZeroes : " + Arrays.deepToString(matrix));
    }
}
