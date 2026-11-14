package stacks_linked_lists.assigment_problems;

public class LastButKAnnouncement {

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

    static String kthFromEnd(Node head, int k) {
        Node lead = head;
        for (int i = 0; i < k; i++) {
            if (lead == null) {
                return "Invalid k";
            }
            lead = lead.next;
        }
        Node trail = head;
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }
        return k + " from the end: " + trail.data;
    }

    public static void main(String[] args) {
        System.out.println(kthFromEnd(build(301, 302, 303, 304, 305, 306), 2));
        System.out.println(kthFromEnd(build(301, 302, 303), 5));
    }
}
