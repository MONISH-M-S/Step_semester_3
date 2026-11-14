package sorting_algorithms.class_problems;

public class PrintCircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.data);
            current = current.next;
            if (current != head) {
                sb.append(" ");
            }
        } while (current != head);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        a.next = b;
        b.next = c;
        c.next = a;
        printCircular(a);
        printCircular(null);
    }
}
