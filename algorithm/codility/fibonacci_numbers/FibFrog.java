package algorithm.codility.fibonacci_numbers;

import java.util.*;

/**
 * 문제
 * - 피보나치 수열
 * - BFS
 *
 * The Fibonacci sequence is defined using the following recursive formula:
 *
 *     F(0) = 0
 *     F(1) = 1
 *     F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
 *
 * The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 *
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
 *
 * For example, consider array A such that:
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 *
 * For example, given:
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * the function should return 3, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 *
 * 피보나치 수열은 다음과 같은 재귀 공식을 사용하여 정의됩니다.
 *
 *     F(0) = 0
 *     이다(1) = 1
 *     M >= 2이면 F(M) = F(M - 1) + F(M - 2)입니다.
 * 작은 개구리가 강 건너편으로 가고 싶어합니다. 개구리는 처음에 강의 한 둑(위치 -1)에 위치하고 다른 둑(위치 N)으로 가고 싶어합니다. 개구리는 F(K)만큼 아무 거리나 점프할 수 있는데, 여기서 F(K)는 K번째 피보나치 수입니다. 다행히도 강에는 많은 잎이 있고 개구리는 잎 사이로 점프할 수 있지만, 위치 N의 둑 방향으로만 가능합니다.
 *
 * 강의 잎은 N개의 정수로 구성된 배열 A로 표현됩니다. 배열 A의 연속적인 요소는 강의 0에서 N-1까지의 연속적인 위치를 나타냅니다. 배열 A에는 0과/또는 1만 포함됩니다.
 *
 * 0은 리프가 없는 위치를 나타냅니다.
 * 1은 리프를 포함하는 위치를 나타냅니다.
 * 목표는 개구리가 강 반대편(위치 -1에서 위치 N)으로 갈 수 있는 최소 점프 횟수를 세는 것입니다. 개구리는 위치 -1과 N(강둑) 사이와 잎이 있는 모든 위치 사이를 점프할 수 있습니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 생각해 보겠습니다.
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * 개구리는 길이가 F(5) = 5, F(3) = 2, F(5) = 5인 점프를 3번 할 수 있습니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면 개구리가 강 반대편으로 갈 수 있는 최소 점프 횟수를 반환합니다. 개구리가 강 반대편에 도달할 수 없다면 함수는 −1을 반환해야 합니다.
 *
 * 예를 들어, 다음이 주어진다:
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * 위에서 설명한 대로 함수는 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 다음 값 중 하나를 가질 수 있는 정수입니다: 0, 1.
 */
public class FibFrog {
    public static void main(String[] args) {
        int[] A = new int[] {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int N = A.length;

        List<Integer> fib = new ArrayList<>(); // 1, 2, 3, 5, 8, 13 ..
        fib.add(1);  // F(1)
        fib.add(2);  // F(2)

        // 배열 길이 보다 작은 값만큼 피보나치 수열 저장
        while (fib.get(fib.size() - 1) <= N) {
            int nextFib = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(nextFib);
        }

        // BFS를 위한 큐 (현재 위치, 점프 횟수)
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(-1); // 개구리 시작 위치 -1 에서 시작
        visited[0] = true; // 시작 위치 true 처리

        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int f : fib) {
                    // 현재 위치에서 피보나치 수열 값만큼 더한 값 추출
                    int nextPosition = current + f;

                    // 끝 위치 도달 시, 점프 횟수 반환
                    if (nextPosition == N) {
                        return jumps + 1;
                    }

                    // 1. 피보나치 수열의 값이 N 보다 작고
                    // 2. 피보나치 수열 위치 값이 1 (점프 가능 값인지 확인)
                    // 3. 방문하지 않은 곳인 경우
                    if (nextPosition < N && A[nextPosition] == 1 && !visited[nextPosition]) {
                        visited[nextPosition] = true; // 방문 처리
                        queue.add(nextPosition); // 해당 위치 큐 삽입
                    }
                }

                // 점프 횟수 증가
                jumps++;
            }
        }

        // 끝에 도달할 수 없으면 -1을 반환
        return -1;
    }
}
