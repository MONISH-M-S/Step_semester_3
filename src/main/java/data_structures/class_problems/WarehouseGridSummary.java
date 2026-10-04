package data_structures.class_problems;

public class WarehouseGridSummary {

    static Object[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0, maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new Object[]{total, new int[]{maxRow, maxCol}};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        Object[] result = warehouseSummary(grid);
        int[] coordinate = (int[]) result[1];
        System.out.println("(" + result[0] + ", (" + coordinate[0] + ", " + coordinate[1] + "))");
    }
}
