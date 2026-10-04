package data_structures.assigment_problems;

public class HotWeatherAlertWindows {

    static int countAlerts(int[] readings, int k, int threshold) {
        int n = readings.length;
        if (k > n) {
            return 0;
        }
        long target = (long) k * threshold;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }
        int count = 0;
        if (windowSum >= target) {
            count++;
        }
        for (int i = k; i < n; i++) {
            windowSum += readings[i] - readings[i - k];
            if (windowSum >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}
