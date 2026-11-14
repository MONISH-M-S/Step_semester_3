package stacks_linked_lists.assigment_problems;

public class MergingTwoWaitlists {

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

    static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (first != null && second != null) {
            if (first.data <= second.data) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        tail.next = first != null ? first : second;
        return dummy.next;
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
        print(merge(build(3, 8, 15), build(5, 8, 20, 25)));
        print(merge(null, build(4, 9)));
    }
}
