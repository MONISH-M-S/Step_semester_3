package sorting_algorithms.class_problems;

public class InsertAtTailDoubly {

    static class DNode {
        int data;
        DNode prev;
        DNode next;

        DNode(int data) {
            this.data = data;
        }
    }

    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }
        DNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }

    static void print(DNode head) {
        StringBuilder sb = new StringBuilder();
        for (DNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(" <-> ");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        DNode head = null;
        head = insertAtTailDoubly(head, 1);
        head = insertAtTailDoubly(head, 2);
        head = insertAtTailDoubly(head, 3);
        head = insertAtTailDoubly(head, 4);
        print(head);
        print(insertAtTailDoubly(null, 7));
    }
}
