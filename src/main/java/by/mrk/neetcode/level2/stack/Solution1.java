package by.mrk.neetcode.level2.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/validate-parentheses/question">Valid Parentheses</a>
 */
public class Solution1 {

    private static final Map<Character, Character> CLOSE_PARENTHESES_2_OPEN = Map.of(
            ')', '(',
            '}', '{',
            ']', '[');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            Character possiblePair = CLOSE_PARENTHESES_2_OPEN.get(c);

            if (stack.isEmpty() || possiblePair == null || !possiblePair.equals(stack.peekLast())) {
                stack.add(c);
            } else {
                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }
}
