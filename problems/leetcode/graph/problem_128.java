package problems.leetcode.graph;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class problem_128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 2, 3}));
    }

    private static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hash = new HashSet<>();
        int maxLength = 0;

        // 적재
        for (int num : nums) {
            hash.add(num);
        }

        for (int num : nums) {
            // 현재 참조 중인 값 보다 1 작은 값이 hash 에 적재되어 있는지 확인 (예 - 현재 참조 중인 값 : 2 / 1 작은 값 : 1)
            if (!hash.contains(num - 1)) { // 시작값인 경우 (이전 값이 존재하지 않는 경우)
                int currentNum = num;
                int currentLength = 1;

                // 해당 시작값을 기준으로 뒤로 몇개까지 있는지 확인
                while (hash.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
