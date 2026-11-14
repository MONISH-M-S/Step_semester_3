package stacks_linked_lists.class_problems;

public class EditorUndoHistory {

    static class Editor {
        private final String[] history;
        private int top = -1;

        Editor(int capacity) {
            history = new String[capacity];
        }

        void type(String word) {
            if (top == history.length - 1) {
                System.out.println("rejected: history full");
                return;
            }
            history[++top] = word;
            show();
        }

        void undo() {
            if (top == -1) {
                System.out.println("rejected: nothing to undo");
                return;
            }
            history[top--] = null;
            show();
        }

        private void show() {
            if (top == -1) {
                System.out.println("(empty)");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= top; i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(history[i]);
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor(3);
        String[] commands = {
            "TYPE Hi", "TYPE there", "TYPE all", "TYPE now",
            "UNDO", "UNDO", "UNDO", "UNDO"
        };
        for (String cmd : commands) {
            if (cmd.startsWith("TYPE ")) {
                editor.type(cmd.substring(5));
            } else {
                editor.undo();
            }
        }
    }
}
