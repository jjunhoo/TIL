package algorithm.codility.arrays;

/**
 * 문제
 * - XOR : 교환법칙, 결합법칙, 동일 숫자 XOR 의 경우 - 0, 자기 자신과 0 XOR 의 경우 - 자기 자신
 *
 * 시간복잡도 : O(N)
 * - 배열을 1번 순회하므로 선형 시간 소요
 * 공간복잡도 : O(1)
 * - 결과값 저장 변수 1개만 사용
 *
 *
 * A non-empty array A consisting of N integers is given.
 * The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 *
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 *
 * the function should return 7, as explained in the example above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 *
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어졌습니다. 배열에는 홀수의 요소가 포함되어 있으며, 배열의 각 요소는 같은 값을 가진 다른 요소와 쌍을 이룰 수 있지만, 한 요소는 쌍을 이루지 않은 채로 남습니다.
 *
 * 예를 들어, 배열 A에서 다음과 같습니다.
 *
 *   A[0] = 9 A[1] = 3 A[2] = 9
 *   A[3] = 3 A[4] = 9 A[5] = 7
 *   A[6] = 9
 * 인덱스 0과 2의 요소는 값 9를 갖습니다.
 * 인덱스 1과 3의 요소는 값 3을 갖습니다.
 * 인덱스 4와 6의 요소는 값 9를 갖습니다.
 * 인덱스 5의 요소는 값 7을 가지고 있으며 쌍이 없습니다.
 * 함수를 작성하세요:
 *
 * 클래스 솔루션 { public int 솔루션(int[] A); }
 *
 * 위의 조건을 만족하는 N개의 정수로 구성된 배열 A가 주어졌을 때, 쌍을 이루지 않은 요소의 값을 반환합니다.
 *
 * 예를 들어, 다음과 같은 배열 A가 주어졌습니다.
 *
 *   A[0] = 9 A[1] = 3 A[2] = 9
 *   A[3] = 3 A[4] = 9 A[5] = 7
 *   A[6] = 9
 * 위의 예에서 설명한 대로, 함수는 7을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하세요 .
 *
 * N은 [1..1,000,000] 범위 내의 홀수 정수입니다.
 * 배열 A의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수입니다 .
 * A의 값 중 하나를 제외한 나머지 값은 짝수 번 나타납니다.
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A)); // 7
    }

    private static int solution(int[] A) {
        int result = 0;

        for (int num : A) {
            result ^= num;
        }

        return result;
    }
}
