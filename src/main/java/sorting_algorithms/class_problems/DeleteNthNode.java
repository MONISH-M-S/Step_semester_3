package sorting_algorithms.class_problems;

public class DeleteNthNode {

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

    static Node deleteNthNode(Node head, int n) {
        if (n == 1) {
            return head.next;
        }
        Node current = head;
        for (int i = 0; i < n - 2; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    static void print(Node head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(" -> ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        print(deleteNthNode(build(10, 20, 30, 40), 3));
        print(deleteNthNode(build(10, 20, 30, 40), 1));
    }
}
