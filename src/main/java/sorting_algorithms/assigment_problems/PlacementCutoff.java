package sorting_algorithms.assigment_problems;

public class PlacementCutoff {

    static int kthHighest(int[] marks, int k) {
        int[] a = marks.clone();
        int target = a.length - k;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int p = partition(a, lo, hi);
            if (p == target) {
                return a[p];
            } else if (p < target) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }
        return a[lo];
    }

    static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[hi];
        a[hi] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(kthHighest(new int[] {72, 95, 60, 88, 79}, 2));
        System.out.println(kthHighest(new int[] {50, 90, 90, 70}, 2));
    }
}
