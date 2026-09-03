package by.mrk.neetcode.level2.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * <a href="https://neetcode.io/problems/minimum-stack/question">Min Stack</a>
 */
public class Solution2 {

    static class MinStack {

        private int nextElementPointer;
        private int minElementsPointer;

        private int[] stack;
        private int[] minElements;

        public MinStack() {
            stack = new int[10];
            minElements = new int[10];
        }

        public void push(int val) {
            stack[nextElementPointer] = val;
            nextElementPointer++;
            resizeIfNeeded();

            if (minElementsPointer == 0) {
                minElements[minElementsPointer] = val;
            } else {
                minElements[minElementsPointer] = Math.min(val, minElements[minElementsPointer - 1]);
            }
            minElementsPointer++;
        }

        public void pop() {
            throwIfEmpty();
            nextElementPointer--;
            minElementsPointer--;
        }

        public int top() {
            throwIfEmpty();
            return stack[nextElementPointer - 1];
        }

        public int getMin() {
            throwIfEmpty();
            return minElements[minElementsPointer - 1];
        }

        private void throwIfEmpty() {
            if (nextElementPointer == 0) {
                throw new NoSuchElementException("empty stack");
            }
        }

        private void resizeIfNeeded() {
            if (stack.length == nextElementPointer) {
                stack = Arrays.copyOf(stack, (int) (stack.length * 1.5) + 1);
            }
            if (minElementsPointer == minElements.length) {
                minElements = Arrays.copyOf(minElements, (int) (minElements.length * 1.5) + 1);
            }
        }
    }
}
