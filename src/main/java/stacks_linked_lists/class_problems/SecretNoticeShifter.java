package stacks_linked_lists.class_problems;

public class SecretNoticeShifter {

    static String shiftNotice(String text, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + k) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + k) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("\"" + shiftNotice("Lab at 5 PM", 3) + "\"");
        System.out.println("\"" + shiftNotice("xyz", 2) + "\"");
    }
}
