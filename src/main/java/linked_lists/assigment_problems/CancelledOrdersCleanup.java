package linked_lists.assigment_problems;

public class CancelledOrdersCleanup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node build(int... values) {
        Node head = null;
        Node tail = null;
        for (int v : values) {
            Node n = new Node(v);
            if (head == null) {
                head = n;
            } else {
                tail.next = n;
            }
            tail = n;
        }
        return head;
    }

    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }
        Node prev = head;
        while (prev != null && prev.next != null) {
            if (prev.next.data == code) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(removeAll(build(5, 3, 5, 8, 5), 5));
        print(removeAll(build(5, 5, 5), 5));
    }
}
