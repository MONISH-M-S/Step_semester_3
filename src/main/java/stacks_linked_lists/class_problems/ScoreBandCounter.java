package stacks_linked_lists.class_problems;

public class ScoreBandCounter {

    static int lowerBound(int[] scores, int x) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (scores[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] scores = {40, 55, 70, 70, 70, 85, 90};
        int[] queries = {70, 60, 95};
        for (int x : queries) {
            int below = lowerBound(scores, x);
            int exactly = lowerBound(scores, x + 1) - below;
            System.out.println(x + ": exactly " + exactly + ", below " + below);
        }
    }
}
