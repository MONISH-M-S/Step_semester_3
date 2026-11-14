package sorting_algorithms.class_problems;

public class RemoveFirstKNodes {

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

    static Node removeFirstKNodes(Node head, int k) {
        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }
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
        print(removeFirstKNodes(build(1, 2, 3, 4, 5), 2));
        print(removeFirstKNodes(build(1, 2), 5));
    }
}
