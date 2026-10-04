package data_structures.assigment_problems;

public class TicketPriceSlotFinder {

    static int findSlot(int[] prices, int newPrice) {
        int lo = 0, hi = prices.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (prices[mid] < newPrice) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println(findSlot(prices, 150));
        System.out.println(findSlot(prices, 210));
        System.out.println(findSlot(prices, 300));
    }
}
