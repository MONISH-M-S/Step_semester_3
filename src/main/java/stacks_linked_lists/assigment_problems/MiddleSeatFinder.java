package stacks_linked_lists.assigment_problems;

public class MiddleSeatFinder {

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

    static int middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        System.out.println("Middle: " + middle(build(11, 22, 33, 44, 55)));
        System.out.println("Middle: " + middle(build(11, 22, 33, 44, 55, 66)));
    }
}
