package LeetCode;

import java.util.Stack;

/**
 * "(()"
 * "()(()"
 * ")()())()()("
 * ")(((((()())()()))()(()))("
 */
public class P32 {
    public static void main(String[] s) {
        System.out.println(new P32().longestValidParentheses(
                ")()())()()("));
    }

    public int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> badStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '(') {
                stack.push(new Node(i));
            } else {
                if (stack.isEmpty()) {
                    badStack.push(new Node(i));
                } else {
                    stack.pop();
                }
            }
        }
        int index = -1;
        int max = 0;
        Stack<Node> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        while (!badStack.isEmpty()) {
            newStack.push(badStack.pop());
        }
        if (newStack.isEmpty()) {
            return s.length();
        }
        while (!newStack.isEmpty()) {
            int min;
            min = newStack.pop().pos;
            max = Math.max(min - index - 1, max);
            index = min;
            if (newStack.isEmpty()) {
                max = Math.max(s.length() - min - 1, max);
            }
        }

        return max;
    }

    public static class Node {
        public int pos;
        public Node(int pos) {
            this.pos = pos;
        }
    }
}
