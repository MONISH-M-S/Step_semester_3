package sorting_algorithms.class_problems;

public class InsertAtEndCircular {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        newNode.next = head;
        last.next = newNode;
        return head;
    }

    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        do {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        } while (cur != head);
        sb.append("(back to ").append(head.data).append(")");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        print(insertAtEndCircular(head, 4));
        print(insertAtEndCircular(null, 9));
    }
}
