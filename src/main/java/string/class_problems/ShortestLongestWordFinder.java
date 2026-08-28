package string.class_problems;

public class ShortestLongestWordFinder {

    static String[] findShortestAndLongestWord(String text) {
        String[] words = text.trim().split("\\s+");
        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        String input = "Java is an object oriented programming language";
        String[] result = findShortestAndLongestWord(input);
        System.out.printf("Shortest: \"%s\" (%d) | Longest: \"%s\" (%d)%n",
                result[0], result[0].length(), result[1], result[1].length());
    }
}
