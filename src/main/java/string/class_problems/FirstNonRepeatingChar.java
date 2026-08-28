package string.class_problems;

public class FirstNonRepeatingChar {

    static Character findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        for (char c : text.toCharArray()) {
            frequency[c]++;
        }
        for (char c : text.toCharArray()) {
            if (frequency[c] == 1) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        for (String input : inputs) {
            Character result = findFirstNonRepeatingChar(input);
            if (result != null) {
                System.out.println("\"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + input + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}
