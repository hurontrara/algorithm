package codeTree.intermediateLow.bfs.section1;

import java.util.Scanner;

public class Q5 {

    static int rowSize, colSize;
    static int[][] matrix;

    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;
    static int iceSize;

    public static void main(String[] args) {
        setting();

        int time = 0;
        while (true) {

            count = 0;
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    visited[i][j] = 0;
                }
            }

            visited[0][0] = 1;
            count++;
            dfs(0, 0);

            if (count == rowSize * colSize) {
                System.out.println(time + " " + iceSize);
                break;
            }

            iceSize = 0;
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    if (matrix[row][col] == 1) {
                        iceSize++;
                    }
                }
            }
            time++;

            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {

                    if (visited[row][col] == 1) {
                        iceToWater(row, col);
                    }

                }
            }




        }


    }

    private static void iceToWater(int row, int col) {

        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existCheck(postRow, postCol)) {
                matrix[postRow][postCol] = 0;
            }
        }

    }

    private static boolean existCheck(int row, int col) {

        return (row >= 0 && row < rowSize && col >= 0 && col < colSize);
    }

    private static void dfs(int row, int col) {

        for (int dir = 0; dir < 4; dir++) {
            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                count++;
                visited[postRow][postCol] = 1;
                dfs(postRow, postCol);
            }

        }

    }

    private static boolean existAndCanGoCheck(int row, int col) {
        return (row >= 0 && row < rowSize && col >= 0 && col < colSize && matrix[row][col] == 0 && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        rowSize = sc.nextInt(); colSize = sc.nextInt();
        matrix = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        visited = new int[rowSize][colSize];


    }


}
