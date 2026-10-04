package data_structures.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCanteenOrder {

    static Object[] mostPopular(List<String> orders) {
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        int maxCount = 0;
        String maxItem = null;
        for (String item : orders) {
            int count = counts.get(item);
            if (count > maxCount) {
                maxCount = count;
                maxItem = item;
            }
        }
        return new Object[]{maxItem, maxCount};
    }

    public static void main(String[] args) {
        List<String> orders1 = Arrays.asList("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        Object[] result1 = mostPopular(orders1);
        System.out.println("(" + result1[0] + ", " + result1[1] + ")");

        List<String> orders2 = Arrays.asList("tea", "coffee", "coffee", "tea");
        Object[] result2 = mostPopular(orders2);
        System.out.println("(" + result2[0] + ", " + result2[1] + ")");
    }
}
