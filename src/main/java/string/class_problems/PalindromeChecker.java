package string.class_problems;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }

    public static void main(String[] args) {
        String[] inputs = {"madam", "hello"};

        for (String input : inputs) {
            boolean iterative = isPalindromeIterative(input);
            boolean recursive = isPalindromeRecursive(input);
            boolean arrayReversal = isPalindromeArrayReversal(input);

            System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    input,
                    iterative ? "Palindrome" : "Not Palindrome",
                    recursive ? "Palindrome" : "Not Palindrome",
                    arrayReversal ? "Palindrome" : "Not Palindrome");
        }
    }
}
