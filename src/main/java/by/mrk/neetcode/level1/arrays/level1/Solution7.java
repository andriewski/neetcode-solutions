package by.mrk.neetcode.level1.arrays.level1;

/**
 * <a href="https://neetcode.io/problems/products-of-array-discluding-self/question">Products of Array Except Self</a>
 */
public class Solution7 {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            result[i + 1] = nums[i] * result[i];
        }

        int postfix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix *= nums[i];
        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int[] prefixMultiplications = new int[nums.length];
        prefixMultiplications[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            prefixMultiplications[i + 1] = nums[i] * prefixMultiplications[i];
        }

        int[] postfixMultiplications = new int[nums.length];
        postfixMultiplications[nums.length - 1] = 1;

        for (int i = nums.length - 1; i >= 1; i--) {
            postfixMultiplications[i - 1] = nums[i] * postfixMultiplications[i];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixMultiplications[i] * postfixMultiplications[i];
        }

        return result;
    }
}
