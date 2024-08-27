package problems.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class problem_15 {

    /**
     * case 1.
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     *
     * case 2.
     * Input: nums = [0,1,1]
     * Output: []
     *
     * case 3.
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = { -1,0,1,2,-1,-4 }; // [-1,-1,2],[-1,0,1]

        List<List<Integer>> result = threeSum(arr);

        for (List<Integer> triplet : result) {
            System.out.println("[triplet] : ");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // 1. 배열 정렬
        // [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        System.out.println("[sort] : " + Arrays.toString(nums));

        // 2. 투 포인터
        // - 3개 포인터 사용
        // -> 1번째 포인터는 -4 부터 시작 (배열 시작)
        // -> 2번째 포인터는 -1 부터 시작 (i + 1)
        // -> 3번째 포인터는 2 부터 시작 (배열 끝)
        for (int i = 0; i < nums.length - 2; i++) {

            // 중복값 SKIP
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // 2번째 포인터
            int right = nums.length - 1; // 3번째 포인터

            System.out.println("[while] left : " + left + " / right : " + right);

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right]; // 1번 포인터, 2번 포인터, 3번 포인터

                // 1. 3개의 수 합이 '0' 인 경우
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복 값 skip // TODO
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) { // TODO
                    left++;
                } else {
                    right--;
                }
            }

            return result;
        }
        

        // 3. 중복 skip

        return Collections.emptyList();
    }

}
