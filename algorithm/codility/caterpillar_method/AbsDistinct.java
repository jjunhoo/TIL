package algorithm.codility.caterpillar_method;

import java.util.HashSet;
import java.util.Set;

/**
 * 문제
 * - 절대값 중복값 제거
 *
 * A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.
 *
 * For example, consider array A such that:
 *
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] =  0
 *   A[4] =  3
 *   A[5] =  6
 * The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.
 *
 * For example, given array A such that:
 *
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] =  0
 *   A[4] =  3
 *   A[5] =  6
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 * array A is sorted in non-decreasing order.
 *
 * N개의 숫자로 구성된 비어 있지 않은 배열 A가 주어졌습니다. 배열은 감소하지 않는 순서로 정렬되었습니다. 이 배열의 절대 고유 카운트 는 배열의 요소 중 고유한 절대 값의 수입니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 생각해 보겠습니다.
 *
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] = 0
 *   A[4] = 3
 *   A[5] = 6
 * 이 배열의 절대 고유 카운트는 5입니다. 왜냐하면 이 배열의 요소 사이에 0, 1, 3, 5, 6이라는 5개의 고유 절대값이 있기 때문입니다.
 *
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * N개의 숫자로 구성된 비어 있지 않은 배열 A가 주어지면, 배열 A의 절대 고유 개수를 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *   A[0] = -5
 *   A[1] = -3
 *   A[2] = -1
 *   A[3] = 0
 *   A[4] = 3
 *   A[5] = 6
 * 위에서 설명한 대로 함수는 5를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ -2,147,483,648 .. 2,147,483,647 ] 범위 내의 정수입니다 .
 * 배열 A는 감소하지 않는 순서로 정렬되어 있습니다.
 */
public class AbsDistinct {
    public static void main(String[] args) {
        int[] A =  new int[]{-5, -3, -1, 0, 3, 6};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int number : A) {
            set.add(Math.abs(number));
        }

        return set.size();
    }
}
