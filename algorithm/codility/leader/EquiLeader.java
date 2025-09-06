package algorithm.codility.leader;

/**
 * 문제
 *
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다.
 *
 * 이 배열의 리더 는 A의 요소 중 절반 이상에 나타나는 값입니다.
 *
 * 동등 리더 는 0 ≤ S < N − 1인 인덱스 S이고 두 시퀀스 A[0], A[1], ..., A[S]와 A[S + 1], A[S + 2], ..., A[N − 1]이 동일한 값의 리더를 갖습니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *     A[0] = 4
 *     [1] = 3입니다.
 *     [2] = 4 입니다.
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * 우리는 두 명의 동등한 리더를 찾을 수 있습니다:
 *
 * 0, 시퀀스 (4)와 (3, 4, 4, 4, 2)가 동일한 리더를 갖고 있고 리더의 값은 4이기 때문입니다.
 * 2, 시퀀스 (4, 3, 4)와 (4, 4, 2)는 동일한 리더를 갖고 있으며 리더의 값은 4입니다.
 * 목표는 동등 리더의 수를 세는 것입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌을 때, 동등 리더의 수를 반환합니다.
 *
 * 예를 들어, 다음이 주어진다:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 *
 * 위에서 설명한 대로 함수는 2를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -1,000,000,000 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 */
public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(A)); // 2
    }

    private static int solution(int[] A) {
        int N = A.length;

        // 리더 후보 탐색
        int candidate = findCandidate(A, N);

        // 리더 후보 존재 여부 확인
        if (candidate == -1) {
            return 0;
        }

        // 후보가 리더인지 확인
        int leaderCount = countLeader(A, N, candidate);

        // 후보가 전체 배열에서 과반수 이상을 차지하는지 확인
        if (leaderCount <= N / 2) {
            return 0;
        }

        int equiLeaders = 0;
        int leftCount = 0; // 왼쪽 배열 내 리더 후보 카운트
        int rightCount = leaderCount; // 오른쪽 배열에서의 리더 후보 카운트

        for (int K = 0; K < N; K++) {
            if (A[K] == candidate) {
                leftCount++;
                rightCount--;
            }

            if (leftCount > (K + 1) / 2 && rightCount > (N - K - 1) / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }

    private static int findCandidate(int[] A, int N) {
        int candidate = -1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (count == 0) {
                candidate = A[i];
                count = 1;
            } else {
                if (A[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count > 0) { // 후보가 실제 리더인지 확인
            return candidate;
        } else {
            return -1; // 리더 후보가 없으면 -1 반환
        }
    }

    private static int countLeader(int[] A, int N, int candidate) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
            }
        }

        return count;
    }
}
