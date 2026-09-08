package by.mrk.neetcode.level3.twopointers;

/**
 * <a href="https://neetcode.io/problems/two-integer-sum-ii/question">Two Integer Sum II</a>
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < numbers.length && j >= 0) {
            int sum = numbers[i] + numbers[j];

            if (sum > target) {
                j--;
                continue;
            } else if (sum < target) {
                i++;
                continue;
            }

            break;
        }

        return new int[] {i + 1, j + 1};
    }
}
