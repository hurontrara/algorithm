package codeTree.intermediateLow.dfs.section1;

import java.util.Scanner;

public class Q2 {

    static int rowSize;
    static int colSize;
    static int[][] matrix;
    static int[][] visited;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int endRow;
    static int endCol;

    public static void main(String[] args) {

        setting();

        dfs(0, 0);

        System.out.println(0);


    }

    private static void dfs(int row, int col) {

        if (row == endRow && col == endCol) {

            System.out.println(1);

            System.exit(0);
        }

        for (int dir = 0; dir < 2; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {

                visited[postRow][postCol] = 1;

                dfs(postRow, postCol);
            }

        }

    }

    private static boolean existAndCanGoCheck(int row, int col) {

        return (row >= 0 && row < rowSize && col >= 0 && col < colSize && matrix[row][col] == 1 && visited[row][col] == 0);
    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);
        rowSize = sc.nextInt(); colSize = sc.nextInt();
        matrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        endRow = rowSize - 1;
        endCol = colSize - 1;

        visited = new int[rowSize][colSize];
        visited[0][0] = 1;

    }


}
