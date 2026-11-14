package sorting_algorithms.class_problems;

public class ReverseFirstKNodes {

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

    static Node reverseFirstKNodes(Node head, int k) {
        Node prev = null;
        Node current = head;
        for (int i = 0; i < k && current != null; i++) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = current;
        return prev;
    }

    static void print(Node head) {
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
        print(reverseFirstKNodes(build(1, 2, 3, 4, 5), 3));
        print(reverseFirstKNodes(build(1, 2, 3, 4, 5), 5));
    }
}
