package linked_lists.assigment_problems;

public class RoundRobinGameTurns {

    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    static class Circle {
        private Node tail;

        void addLast(String name) {
            Node n = new Node(name);
            if (tail == null) {
                n.next = n;
            } else {
                n.next = tail.next;
                tail.next = n;
            }
            tail = n;
        }

        void printTurns(int turns) {
            if (tail == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            Node cur = tail.next;
            for (int i = 0; i < turns; i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(cur.name);
                cur = cur.next;
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.addLast("Asha");
        circle.addLast("Ravi");
        circle.addLast("Neha");
        circle.printTurns(7);
    }
}
