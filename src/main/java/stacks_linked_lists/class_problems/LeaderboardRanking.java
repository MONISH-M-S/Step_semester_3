package stacks_linked_lists.class_problems;

public class LeaderboardRanking {

    static class Participant {
        String name;
        int score;

        Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    static void insertionSort(Participant[] p) {
        for (int i = 1; i < p.length; i++) {
            Participant key = p[i];
            int j = i - 1;
            while (j >= 0 && p[j].score < key.score) {
                p[j + 1] = p[j];
                j--;
            }
            p[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Participant[] entries = {
            new Participant("Asha", 90),
            new Participant("Ravi", 85),
            new Participant("Neha", 90),
            new Participant("Kiran", 70)
        };
        insertionSort(entries);
        int rank = 0;
        for (int i = 0; i < entries.length; i++) {
            if (i == 0 || entries[i].score != entries[i - 1].score) {
                rank = i + 1;
            }
            System.out.println(rank + " " + entries[i].name + " " + entries[i].score);
        }
    }
}
