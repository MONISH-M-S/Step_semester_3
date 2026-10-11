package linked_lists.class_problems;

public class ClassMarksGridAnalysis {

    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        int[] totals = new int[names.length];
        double[] subjectSums = new double[3];
        int top = 0;
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectSums[j] += marks[i][j];
            }
            if (totals[i] > totals[top]) {
                top = i;
            }
        }
        StringBuilder t = new StringBuilder("Totals ");
        for (int i = 0; i < names.length; i++) {
            if (i > 0) {
                t.append(", ");
            }
            t.append(names[i]).append(" ").append(totals[i]);
        }
        System.out.println(t);
        StringBuilder a = new StringBuilder("averages ");
        for (int j = 0; j < 3; j++) {
            if (j > 0) {
                a.append(", ");
            }
            a.append(String.format("%.2f", subjectSums[j] / names.length));
        }
        System.out.println(a);
        System.out.println("topper " + names[top] + " (" + totals[top] + ")");
    }
}
