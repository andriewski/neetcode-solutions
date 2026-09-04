package by.mrk.neetcode.level2.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://neetcode.io/problems/evaluate-reverse-polish-notation/question">Evaluate Reverse Polish Notation</a>
 */
public class Solution3 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new ArrayDeque<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0)) || (token.length() > 1 && Character.isDigit(token.charAt(1)))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int left = numbers.pop();
                int right = numbers.pop();

                numbers.push(calculate(right, left, token.charAt(0)));
            }
        }

        return numbers.pop();
    }

    public static int calculate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
