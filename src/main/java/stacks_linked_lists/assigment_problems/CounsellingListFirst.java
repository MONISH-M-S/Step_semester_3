package stacks_linked_lists.assigment_problems;

public class CounsellingListFirst {

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

    static Node partition(Node head, int passMark) {
        Node lowHead = null;
        Node lowTail = null;
        Node highHead = null;
        Node highTail = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            if (cur.data < passMark) {
                if (lowHead == null) {
                    lowHead = cur;
                } else {
                    lowTail.next = cur;
                }
                lowTail = cur;
            } else {
                if (highHead == null) {
                    highHead = cur;
                } else {
                    highTail.next = cur;
                }
                highTail = cur;
            }
            cur = next;
        }
        if (lowHead == null) {
            return highHead;
        }
        lowTail.next = highHead;
        return lowHead;
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
        print(partition(build(55, 32, 78, 20, 40, 35), 40));
        print(partition(build(60, 70), 40));
    }
}
