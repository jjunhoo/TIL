package algorithm.codility.leader;

/**
 * 문제
 * - 정수 배열 A가 주어질 때, 배열에서 최대 빈도 수를 가진 값(= 지배자, Dominator)을 찾고, 그 값의 인덱스 중 하나 리턴
 * Dominator : 배열 요소 중 절반 이상(n/2 초과) 등장하는 값
 *
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 *
 *
 * N개의 정수로 구성된 배열 A가 주어졌습니다. 배열 A의 지배자는 A의 절반 이상의 요소에 나타나는 값입니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 생각해 보세요.
 *
 * A[0] = 3 A[1] = 4 A[2] = 3
 *  A[3] = 2 A[4] = 3 A[5] = -1
 *  A[6] = 3 A[7] = 3
 * A의 지배자는 3입니다. 왜냐하면 A의 8개 요소 중 5개(즉, 인덱스 0, 2, 4, 6, 7을 갖는 요소)에 나타나며 5는 8의 절반보다 크기 때문입니다.
 *
 * 함수를 작성하세요
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면, 배열 A의 지배자가 있는 배열 A의 모든 요소의 인덱스를 반환합니다. 배열 A에 지배자가 없으면 함수는 -1을 반환해야 합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 * A[0] = 3 A[1] = 4 A[2] = 3
 *  A[3] = 2 A[4] = 3 A[5] = -1
 *  A[6] = 3 A[7] = 3
 * 위에서 설명한 대로, 함수는 0, 2, 4, 6 또는 7을 반환할 수 있습니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -2,147,483,648 .. 2,147,483,647 ] 범위 내의 정수입니다 .
 */
public class Dominator {
    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(solution(A)); // 예시 출력: 0 (또는 다른 3의 인덱스)
    }

    private static int solution(int[] A) {
        int N = A.length;

        if (0 == N) {
            return -1;
        }

        // Dominator 후보 탐색
        int candidate = findCandidate(A);
        System.out.println("[candidate] : " + candidate);

        int count = 0;
        int index = -1;

        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count++;
                index = i;
            }
        }

        if (count > N / 2) {
            return index;
        } else {
            return -1;
        }
    }

    private static int findCandidate(int[] A) {
        int size = 0;
        int candidate = 0;

        // 3, 4, 3, 2, 3, -1, 3, 3
        for (int num : A) {
            if (size == 0) {
                candidate = num;
                size++;
            } else {
                if (num == candidate) {
                    size++;
                } else {
                    size--;
                }
            }
        }

        System.out.println("size " + size);

        return candidate;
    }
}
