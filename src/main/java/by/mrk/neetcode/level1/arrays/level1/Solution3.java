package by.mrk.neetcode.level1.arrays.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/two-integer-sum/question">Two Sum</a>
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> number2Index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int missingPart = target - nums[i];

            if (number2Index.containsKey(missingPart)) {
                Integer missingPartIndex = number2Index.get(missingPart);

                return new int[] {Math.min(i, missingPartIndex), Math.max(i, missingPartIndex)};
            } else {
                number2Index.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
