package codeTree.intermediateLow.simulation.exhaustiveSearch;

public class Q1_example {

    public static int size = 5;
    public static int[][] matrix = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
    };

    public static void main(String[] args) {

        int maxGold = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (col + 2 >= size) {
                    continue;
                }

                int numOfGold = getNumOfGold(row, col);

                maxGold = Math.max(maxGold, numOfGold);
            }

        }

        System.out.println("maxGold = " + maxGold);
    }

    private static int getNumOfGold(int row, int col) {
        int numOfGold = 0;

        for (int localCol = col; localCol <= col + 2; localCol++) {
            numOfGold += matrix[row][localCol];
        }

        return numOfGold;
    }
}