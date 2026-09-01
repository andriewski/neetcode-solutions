package by.mrk.neetcode.level1.arrays.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/longest-consecutive-sequence/question">Longest Consecutive Sequence</a>
 */
public class Solution9 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Range> left2Range = new HashMap<>();
        Map<Integer, Range> right2Range = new HashMap<>();
        int maxSequence = 0;

        for (int num : nums) {
            Range leftRange = left2Range.get(num + 1);

            if (leftRange != null) {
                leftRange.left = num;

                Range possibleRange2Extend = right2Range.get(num - 1);

                if (possibleRange2Extend != null) {
                    // here
                    // 1 2 3 4 - left range
                    // 5 - current number
                    // 6 7 8 - possibleRange2Extend

                    leftRange.left = possibleRange2Extend.left;
                    // remove connected range
                    left2Range.remove(possibleRange2Extend.left);
                    right2Range.remove(possibleRange2Extend.right);
                }

                left2Range.put(leftRange.left, leftRange);
                // removing range before extending it
                left2Range.remove(num + 1);

                maxSequence = Math.max(maxSequence, leftRange.size());
                continue;
            }

            Range rightRange = right2Range.get(num - 1);

            if (rightRange != null) {
                rightRange.right = num;
                right2Range.put(rightRange.right, rightRange);
                // removing range before extending it
                right2Range.remove(num - 1);
                maxSequence = Math.max(maxSequence, rightRange.size());
                continue;
            }

            if (left2Range.containsKey(num) || right2Range.containsKey(num)) {
                continue;
            }

            Range newRange = new Range(num, num);

            left2Range.put(newRange.left, newRange);
            right2Range.put(newRange.right, newRange);
            maxSequence = Math.max(maxSequence, newRange.size());
        }

        return maxSequence;
    }

    static class Range {
        int left;
        int right;

        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int size() {
            return right - left + 1;
        }
    }
}
