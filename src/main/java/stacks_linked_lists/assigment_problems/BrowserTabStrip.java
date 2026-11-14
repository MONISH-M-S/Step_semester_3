package stacks_linked_lists.assigment_problems;

public class BrowserTabStrip {

    static class Tab {
        String name;
        Tab prev;
        Tab next;

        Tab(String name) {
            this.name = name;
        }
    }

    static class TabStrip {
        private Tab head;
        private Tab tail;
        private Tab cur;

        void open(String name) {
            Tab t = new Tab(name);
            if (cur == null) {
                head = t;
                tail = t;
            } else {
                t.prev = cur;
                t.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = t;
                } else {
                    tail = t;
                }
                cur.next = t;
            }
            cur = t;
            System.out.println("OPEN " + name + ": " + strip());
        }

        void close() {
            if (cur == null) {
                System.out.println("CLOSE: no tabs open");
                return;
            }
            Tab removed = cur;
            Tab prev = removed.prev;
            Tab next = removed.next;
            if (prev != null) {
                prev.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.prev = prev;
            } else {
                tail = prev;
            }
            cur = next != null ? next : prev;
            System.out.println("CLOSE " + removed.name + ": " + strip());
        }

        void back() {
            if (cur == null || cur.prev == null) {
                System.out.println("BACK: already at first tab");
                return;
            }
            cur = cur.prev;
            System.out.println("BACK: " + strip());
        }

        void forward() {
            if (cur == null || cur.next == null) {
                System.out.println("FORWARD: already at last tab");
                return;
            }
            cur = cur.next;
            System.out.println("FORWARD: " + strip());
        }

        void printBackward() {
            StringBuilder sb = new StringBuilder("Backward: ");
            for (Tab t = tail; t != null; t = t.prev) {
                sb.append(t.name);
                if (t.prev != null) {
                    sb.append(" <-> ");
                }
            }
            System.out.println(sb);
        }

        private String strip() {
            if (head == null) {
                return "(no tabs)";
            }
            StringBuilder sb = new StringBuilder();
            for (Tab t = head; t != null; t = t.next) {
                sb.append(t == cur ? "[" + t.name + "]" : t.name);
                if (t.next != null) {
                    sb.append(" <-> ");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        TabStrip strip = new TabStrip();
        String[] commands = {
            "OPEN Mail", "OPEN Docs", "OPEN Maps", "BACK", "BACK", "BACK",
            "OPEN Drive", "CLOSE", "FORWARD", "CLOSE", "PRINT BACKWARD"
        };
        for (String cmd : commands) {
            if (cmd.startsWith("OPEN ")) {
                strip.open(cmd.substring(5));
            } else if (cmd.equals("CLOSE")) {
                strip.close();
            } else if (cmd.equals("BACK")) {
                strip.back();
            } else if (cmd.equals("FORWARD")) {
                strip.forward();
            } else {
                strip.printBackward();
            }
        }
    }
}
