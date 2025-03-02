package algorithm.codility.StacksAndQueues;

import java.util.Stack;

/**
 * 문제
 * - 스택을 활용한 비교 방식으로 물고기 생존 여부 판단
 * - 반대 방향으로 만나는 순간만 싸우므로, 필요하지 않은 경우는 비교 X
 *
 * You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.
 *
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.
 *
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
 *
 * 0 represents a fish flowing upstream,
 * 1 represents a fish flowing downstream.
 * If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:
 *
 * If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.
 *
 * For example, consider arrays A and B such that:
 *
 *   A[0] = 4    B[0] = 0
 *   A[1] = 3    B[1] = 1
 *   A[2] = 2    B[2] = 0
 *   A[3] = 1    B[3] = 0
 *   A[4] = 5    B[4] = 0
 * Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and therefore stay alive.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A, int[] B); }
 *
 * that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.
 *
 * For example, given the arrays shown above, the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000];
 * each element of array B is an integer that can have one of the following values: 0, 1;
 * the elements of A are all distinct.
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 두 개의 배열 A와 B가 주어집니다. 배열 A와 B는 강의 흐름을 따라 하류로 정렬된 강의 N개의 탐식성 물고기를 나타냅니다.
 *
 * 물고기는 0에서 N-1까지 번호가 매겨집니다. P와 Q가 두 물고기이고 P < Q인 경우, 물고기 P는 처음에 물고기 Q의 상류에 있습니다. 처음에 각 물고기는 고유한 위치를 갖습니다.
 *
 * 물고기 수 P는 A[P]와 B[P]로 표현됩니다. 배열 A에는 물고기 크기가 들어 있습니다. 모든 요소는 고유합니다. 배열 B에는 물고기 방향이 들어 있습니다. 여기에는 0과/또는 1만 들어 있습니다. 여기서:
 *
 * 0은 상류로 흐르는 물고기를 나타냅니다.
 * 1은 하류로 흐르는 물고기를 나타냅니다.
 * 두 물고기가 반대 방향으로 움직이고 그 사이에 다른 (살아있는) 물고기가 없다면, 그들은 결국 서로 만날 것입니다. 그러면 오직 한 마리의 물고기만 살아남을 수 있습니다. 더 큰 물고기가 작은 물고기를 먹습니다. 더 정확하게 말해서, 우리는 두 물고기 P와 Q가 P < Q, B[P] = 1, B[Q] = 0이고 그 사이에 살아있는 물고기가 없을 때 서로 만난다고 말합니다. 그들이 만난 후:
 *
 * A[P] > A[Q]이면 P가 Q를 먹고 P는 여전히 하류로 흐를 것입니다.
 * A[Q] > A[P]이면 Q가 P를 먹고 Q는 계속 상류로 흐를 것입니다.
 * 우리는 모든 물고기가 같은 속도로 흐른다고 가정합니다. 즉, 같은 방향으로 움직이는 물고기는 결코 만나지 않습니다. 목표는 살아남을 물고기의 수를 계산하는 것입니다.
 *
 * 예를 들어, 다음과 같은 배열 A와 B를 생각해 보겠습니다.
 *
 *   A[0] = 4 B[0] = 0
 *   A[1] = 3 B[1] = 1
 *   A[2] = 2 B[2] = 0
 *   A[3] = 1 B[3] = 0
 *   A[4] = 5 B[4] = 0
 * 처음에는 모든 물고기가 살아 있었고 물고기 번호 1을 제외한 모든 물고기가 상류로 이동하고 있었습니다. 물고기 번호 1은 물고기 번호 2를 만나서 그것을 먹고, 그런 다음 물고기 번호 3을 만나서 역시 먹습니다. 마지막으로 물고기 번호 4를 만나서 먹힙니다. 나머지 두 물고기, 번호 0과 4는 결코 만나지 않아서 살아남습니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A, int[] B); }
 *
 * N개의 정수로 구성된 비어 있지 않은 두 개의 배열 A와 B가 주어졌을 때 살아남을 물고기의 수를 반환합니다.
 *
 * 예를 들어, 위에 표시된 배열이 주어지면 함수는 위에서 설명한 대로 2를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 0 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 * 배열 B의 각 요소는 다음 값 중 하나를 가질 수 있는 정수입니다: 0, 1;
 * A의 원소는 모두 서로 다르다.
 */
public class Fish {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        System.out.println(solution(A, B)); // 2 (4, 5)
    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> downstream = new Stack<>();
        int aliveFishCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) { // 하류로 가는 물고기 - 0:상류 방향, 1:하류 방향
                downstream.push(A[i]);
            } else { // 상류로 가는 물고기
                while (!downstream.isEmpty()) {
                    int downstreamFish = downstream.peek();

                    if (downstreamFish > A[i]) {
                        // 하류 방향으로 가는 물고기 값이 더 큰 경우, 상류 방향으로 가는 물고기 제거
                        break;
                    } else {
                        // 상류 방향으로 가는 물고기 값이 더 큰 경우, 하류 방향으로 가는 물고기 제거
                        downstream.pop();
                    }
                }

                // 상류 방향으로 가는 물고기가 끝까지 살아남았다면 count 증가
                if (downstream.isEmpty()) {
                    aliveFishCount++;
                }
            }
        }

        // 살아남은 물고기 수 = 스택에 남은 하류 물고기 + 살아남은 상류 물고기
        return aliveFishCount + downstream.size();
    }
}
