package by.mrk.neetcode.level1.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://neetcode.io/problems/duplicate-integer/question">Contains Duplicate</a>
 */
public class Solution1 {

    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasDuplicate2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
