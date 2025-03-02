package algorithm.codility.counting_elements;

/**
 * 문제
 *
 *
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 *
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 *
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 *
 * For example, you are given integer X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int[] A); }
 *
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
 *
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 *
 * For example, given X = 5 and array A such that:
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * the function should return 6, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 *
 *
 * 작은 개구리가 강 건너편으로 가려고 합니다.
 * 개구리는 처음에 강의 한 둑(위치 0)에 위치하고 있고 반대쪽 둑(위치 X+1)으로 가려고 합니다.
 * 나뭇잎이 나무에서 강 표면으로 떨어집니다.
 *
 * N개의 정수로 구성된 배열 A가 주어집니다.
 * 이 배열은 떨어지는 나뭇잎을 나타냅니다.
 * A[K]는 시간 K에서 나뭇잎 하나가 떨어지는 위치를 초 단위로 나타냅니다.
 *
 * 목표는 개구리가 강 건너편으로 점프할 수 있는 가장 빠른 시간을 찾는 것입니다.
 * 개구리는 1에서 X까지 강 건너편의 모든 위치에 잎이 나타날 때만 건너갈 수 있습니다(즉, 1에서 X까지 모든 위치가 잎으로 뒤덮이는 가장 빠른 순간을 찾고자 합니다).
 * 강물 흐름의 속도가 무시할 만큼 작다고 가정할 수 있습니다.
 * 즉, 잎은 강에 떨어지면 위치가 바뀌지 않습니다.
 *
 * 예를 들어, 정수 X = 5와 배열 A가 주어졌을 때 다음과 같습니다.
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 *
 * 두 번째 6에서 잎이 위치 5에 떨어집니다. 이것은 강 건너 모든 위치에 잎이 나타나는 가장 빠른 시간입니다.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int X, int[] A); }
 *
 * N개의 정수와 정수 X로 구성된 비어 있지 않은 배열 A가 주어졌을 때, 개구리가 강 반대편으로 점프할 수 있는 가장 빠른 시간을 반환하는 프로그램입니다.
 *
 * 만약 개구리가 강 건너편으로 결코 점프할 수 없다면, 함수는 -1을 반환해야 합니다.
 *
 * 예를 들어, X = 5이고 배열 A가 다음과 같다고 가정합니다.
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 *
 * 위에서 설명한 대로 함수는 6을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N과 X는 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. X ] 범위 내의 정수입니다 .
 */
public class FrogRiverOne {
    public static void main(String[] args) {

        int X = 5;
        // 나뭇잎이 떨어진 위치
        // A[0] 은 시간 0에서 떨어진 나뭇잎의 위치 - 1번째 위치에 떨어짐
        // A[1] 은 시간 1에서 떨어진 나뭇잎의 위치 - 3번째 위치에 떨어짐
        // 즉, 5까지 연속해서 값이 채워져 있냐 없냐 판단
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};

        // 첫 번째로 개구리가 강을 건널 수 있는 시점 출력
        System.out.println(solution(X, A));  // 6
    }

    private static int solution(int X, int[] A) {
        boolean[] positions = new boolean[X + 1]; // 강의 각 위치가 나뭇잎으로 채워졌는지 여부 - true 인 경우, 나뭇잎이 떨어진 것으로 가정
        int count = 0; // 채워진 나뭇잎 수

        // 배열 순회를 통해 나뭇잎이 떨어진 위치 기록
        for (int time = 1; time < A.length; time++) {
            int position = A[time]; // * 나뭇잎이 떨어지는 위치에 대한 position 배열의 인덱스를 계산하기 위한 식

            // 해당 위치에 나뭇잎이 떨어지지 않은 상태인 경우
            if (!positions[position]) {
                positions[position] = true;
                count++;
            }

            // 모든 위치에 나뭇잎이 떨어진 경우, 개구리가 강을 건널 수 있는 시점
            if (count == X) {
                return time;
            }
        }

        // 모든 나뭇잎이 떨어져도 강을 건널 수 없는 경우, -1 리턴
        return -1;
    }
}
