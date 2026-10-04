package data_structures.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergingTwoTokenQueues {

    static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                merged.add(counterA.get(i));
                i++;
            } else {
                merged.add(counterB.get(j));
                j++;
            }
        }
        while (i < counterA.size()) {
            merged.add(counterA.get(i));
            i++;
        }
        while (j < counterB.size()) {
            merged.add(counterB.get(j));
            j++;
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> counterA1 = Arrays.asList(3, 8, 15, 20);
        List<Integer> counterB1 = Arrays.asList(5, 8, 12);
        System.out.println(mergeTokens(counterA1, counterB1));

        List<Integer> counterA2 = new ArrayList<>();
        List<Integer> counterB2 = Arrays.asList(4, 9);
        System.out.println(mergeTokens(counterA2, counterB2));
    }
}
