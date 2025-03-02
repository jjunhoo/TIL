package algorithm.codility.time_complexity;

/**
 * 문제
 * 시간복잡도 : O(1)
 * - 상수 시간 계산
 * 공간복잡도 : O(1)
 * - 추가 메모리 불필요
 *
 * A small frog wants to get to the other side of the road.
 * The frog is currently located at position X and wants to get to a position greater than or equal to Y.
 * The small frog always jumps a fixed distance, D.
 *
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int Y, int D); }
 *
 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 *
 * For example, given:
 *
 *   X = 10
 *   Y = 85
 *   D = 30
 * the function should return 3, because the frog will be positioned as follows:
 *
 * after the first jump, at position 10 + 30 = 40
 * after the second jump, at position 10 + 30 + 30 = 70
 * after the third jump, at position 10 + 30 + 30 + 30 = 100
 * Write an efficient algorithm for the following assumptions:
 *
 * X, Y and D are integers within the range [1..1,000,000,000];
 * X ≤ Y.
 *
 * 작은 개구리가 도로 반대편으로 가려고 합니다.
 * 개구리는 현재 위치 X에 있으며 Y보다 크거나 같은 위치로 가려고 합니다.
 * 작은 개구리는 항상 고정된 거리 D만큼 점프합니다.
 *
 * 작은 개구리가 목표에 도달하기 위해 수행해야 하는 최소한의 점프 횟수를 세어 보세요.
 *
 * 함수를 작성하세요:
 *
 * class Solution { public int solution(int X, int Y, int D); }
 *
 * 세 개의 정수 X, Y, D가 주어졌을 때, 위치 X에서 Y보다 크거나 같은 위치로 점프하는 최소 횟수를 반환합니다.
 *
 * 예를 들어, 다음이 주어진다:
 *
 *   X = 10
 *   Y = 85
 *   D = 30
 * 개구리가 다음과 같이 배치되므로 함수는 3을 반환해야 합니다.
 *
 * 첫 번째 점프 후 위치 10 + 30 = 40
 * 2번째 점프 후, 위치 10 + 30 + 30 = 70
 * 3번째 점프 후, 위치 10 + 30 + 30 + 30 = 100
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * X, Y 및 D는 [ 1 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 * X ≤ Y.
 */
public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    private static int solution(int X, int Y, int D) {
        return (int) Math.ceil((double) (Y - X) / D);
    }
}
