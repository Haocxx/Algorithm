package base;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public Node reverse(Node head) {
        Node pre = head;
        Node cur = head.next;
        pre.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class Node {
        public Node next;
    }
}
