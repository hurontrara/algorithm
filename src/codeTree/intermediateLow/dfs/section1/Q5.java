package codeTree.intermediateLow.dfs.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    static int size;
    static int[][] matrix;
    static int[][] visited;

    static int count = 0;

    static int maxCount = 0;
    static int countNum = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) {

        setting();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int value = matrix[row][col];
                if (visited[row][col] == 0) {

                    visited[row][col] = 1;
                    count++;
                    dfs(row, col, value);

                    if (maxCount < count) {
                        maxCount = count;
                    }

                    if (count >= 4) {
                        countNum++;
                    }

                    count = 0;

                }
            }
        }

        System.out.println(countNum + " " + maxCount);

    }

    private static void dfs(int row, int col, int value) {

        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existAndCanGoCheck(postRow, postCol, value)) {

                count++;
                visited[postRow][postCol] = 1;
                dfs(postRow, postCol, value);

            }

        }
    }

    private static boolean existAndCanGoCheck(int row, int col, int value) {
        return (row >= 0 && row < size && col >= 0 && col < size && visited[row][col] == 0 && matrix[row][col] == value);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        visited = new int[size][size];

    }
}
