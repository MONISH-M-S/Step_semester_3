package linked_lists.assigment_problems;

public class PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class TokenList {
        private Node head;

        void addFirst(int token) {
            Node n = new Node(token);
            n.next = head;
            head = n;
        }

        void addLast(int token) {
            Node n = new Node(token);
            if (head == null) {
                head = n;
                return;
            }
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = n;
        }

        void insertAt(int index, int token) {
            if (index == 0) {
                addFirst(token);
                return;
            }
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node n = new Node(token);
            n.next = prev.next;
            prev.next = n;
        }

        void print() {
            StringBuilder sb = new StringBuilder();
            for (Node cur = head; cur != null; cur = cur.next) {
                sb.append(cur.data).append(" -> ");
            }
            sb.append("null");
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        TokenList list = new TokenList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);
        list.print();
    }
}
