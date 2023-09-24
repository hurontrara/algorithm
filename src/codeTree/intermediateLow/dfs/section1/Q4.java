package codeTree.intermediateLow.dfs.section1;

import java.util.Scanner;

public class Q4 {

    static int rowSize;
    static int colSize;

    static int[][] matrix;
    static int[][] visited;

    static int maxK = 0;

    static int maxCount = Integer.MIN_VALUE;
    static int targetHeight = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        setting();

        for (int height = 1; height <= maxK; height++) {

            matrixSetting(height);

            int count = 0;
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {

                    if (matrix[row][col] != 0 && visited[row][col] == 0) {
                        count++;

                        visited[row][col] = 1;

                        dfs(row, col);

                    }

                }
            }
            if (count > maxCount) {
                maxCount = count;
                targetHeight = height;
            }

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    visited[i][j] = 0;
                }
            }


        }

        System.out.println(targetHeight + " " + maxCount);


    }

    private static void dfs(int row, int col) {

        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {

                visited[postRow][postCol] = 1;

                dfs(postRow, postCol);

            }

        }

    }

    private static boolean existAndCanGoCheck(int row, int col) {

        return (row >= 0 && row < rowSize && col >= 0 && col < colSize && matrix[row][col] != 0 && visited[row][col] == 0);
    }

    private static void matrixSetting(int height) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {

                if (matrix[row][col] == height) {
                    matrix[row][col] = 0;
                }

            }
        }
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        rowSize = sc.nextInt(); colSize = sc.nextInt();
        matrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {

                int value = sc.nextInt();
                matrix[i][j] = value;
                if (value > maxK) {
                    maxK = value;
                }
            }
        }

        visited = new int[rowSize][colSize];

    }


}
