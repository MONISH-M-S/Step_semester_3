package stacks_linked_lists.class_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class PocketCalculator {

    static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    static String toPostfix(String infix) {
        StringBuilder out = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                out.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    out.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    out.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }
        return out.toString();
    }

    static int evaluate(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    default:
                        if (right == 0) {
                            throw new ArithmeticException("division by zero");
                        }
                        stack.push(left / right);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] expressions = {"2+3*4", "(2+3)*4", "8/2-3"};
        for (String expr : expressions) {
            String postfix = toPostfix(expr);
            try {
                System.out.println(postfix + " = " + evaluate(postfix));
            } catch (ArithmeticException e) {
                System.out.println(postfix + " = error: " + e.getMessage());
            }
        }
    }
}
