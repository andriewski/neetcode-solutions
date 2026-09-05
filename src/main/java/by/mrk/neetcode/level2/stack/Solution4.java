package by.mrk.neetcode.level2.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://neetcode.io/problems/daily-temperatures/question">Daily Temperatures</a>
 */
public class Solution4 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<IndexedValue> monotonicDecreasingStack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];

            if (monotonicDecreasingStack.isEmpty()) {
                monotonicDecreasingStack.push(new IndexedValue(i, temperature));
            } else {
                IndexedValue lastValue = monotonicDecreasingStack.peekFirst();

                if (lastValue.temperature > temperature) {
                    result[i] = lastValue.index - i;
                    monotonicDecreasingStack.push(new IndexedValue(i, temperature));
                } else if (lastValue.temperature < temperature) {
                    do {
                        monotonicDecreasingStack.pop();
                        lastValue = monotonicDecreasingStack.peekFirst();
                    } while (lastValue != null && lastValue.temperature <= temperature);

                    monotonicDecreasingStack.push(new IndexedValue(i, temperature));

                    if (lastValue != null && lastValue.temperature > temperature) {
                        result[i] = lastValue.index - i;
                    }
                } else {
                    monotonicDecreasingStack.pop();

                    lastValue = monotonicDecreasingStack.peekFirst();

                    if (lastValue != null && lastValue.temperature > temperature) {
                        result[i] = lastValue.index - i;
                    }

                    monotonicDecreasingStack.push(new IndexedValue(i, temperature));
                }
            }
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
