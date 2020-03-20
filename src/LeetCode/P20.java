package LeetCode;

public class P20 {
    public static void main(String[] s) {

    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (isLeft(value)) {
                stack.push(new Stack.Node(value));
            } else if (isRight(value)) {
                if (stack.top() != null && isPared(stack.top().value, value)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.top() == null;
    }

    private boolean isLeft(char v) {
        return v == '[' || v == '{' || v == '(';
    }

    private boolean isRight(char v) {
        return v == ']' || v == '}' || v == ')';
    }

    private boolean isPared(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }

    public static class Stack {
        public static class Node {
            public char value;
            public Node next;
            public Node pre;
            private Node(char v) {
                value = v;
            }
        }

        private Node mTopNode = new Node('1');
        private Node mNode = mTopNode;

        public Node top() {
            if (mNode == mTopNode) {
                return null;
            }
            return mTopNode;
        }

        public void pop() {
            Node temp = mTopNode.pre;
            mTopNode.pre.next = null;
            mTopNode.pre = null;
            mTopNode = temp;

        }

        public void push(Node node) {
            mTopNode.next = node;
            node.pre = mTopNode;
            mTopNode = node;
        }
    }
}
