package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.Scanner;

public class Q7 {

    public static int n;
    public static int m;
    public static int[][] matrix;
    public static int maxSize = -1;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int row1 = 0; row1 < n; row1++) {
            for (int col1 = 0; col1 < m; col1++) {
                for (int row2 = row1; row2 < n; row2++) {
                    for (int col2 = col1; col2 < m; col2++) {
                        rectangleProcess(row1, col1, row2, col2);
                    }
                }
            }
        }

        System.out.println(maxSize);
    }

    private static void rectangleProcess(int row1, int col1, int row2, int col2) {
        
        int size = (row2 - row1 + 1) * (col2 - col1 + 1);

        for (int i = row1; i < row2 + 1; i++) {
            for (int j = col1; j < col2 + 1; j++) {
                if (matrix[i][j] <= 0) {
                    return;
                }
            }
        }

        maxSize = Math.max(size, maxSize);

    }

}
