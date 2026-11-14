package sorting_algorithms.assigment_problems;

public class ContestLeaderboard {

    static class Entry {
        String name;
        int marks;

        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];
        for (Entry e : entries) {
            count[100 - e.marks]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        Entry[] out = new Entry[entries.length];
        for (int i = entries.length - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            out[--count[key]] = entries[i];
        }
        return out;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };
        Entry[] result = leaderboard(entries);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(result[i]);
        }
        System.out.println(sb);
    }
}
