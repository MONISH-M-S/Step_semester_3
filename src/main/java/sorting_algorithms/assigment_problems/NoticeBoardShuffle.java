package sorting_algorithms.assigment_problems;

import java.util.Arrays;

public class NoticeBoardShuffle {

    static int[] bubbleStats(int[] scores) {
        int passes = 0;
        int swaps = 0;
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int t = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = t;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return new int[] {passes, swaps};
    }

    static void run(int[] scores) {
        int[] stats = bubbleStats(scores);
        System.out.println(Arrays.toString(scores) + " passes = " + stats[0] + ", swaps = " + stats[1]);
    }

    public static void main(String[] args) {
        run(new int[] {5, 1, 4, 2, 8});
        run(new int[] {1, 2, 3, 4});
    }
}
