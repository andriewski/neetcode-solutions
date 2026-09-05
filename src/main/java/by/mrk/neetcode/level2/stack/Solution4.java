package by.mrk.neetcode.level2.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://neetcode.io/problems/daily-temperatures/question">Daily Temperatures</a>
 */
public class Solution4 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<IndexedValue> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().temperature) {
                IndexedValue previousTemperature = stack.pop();
                result[previousTemperature.index] = i - previousTemperature.index;
            }

            stack.push(new IndexedValue(i, temperatures[i]));
        }

        return result;
    }

    static class IndexedValue {

        int index;
        int temperature;

        public IndexedValue(int index, int value) {
            this.index = index;
            this.temperature = value;
        }
    }
}
