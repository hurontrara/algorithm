package codeTree.intermediateLow.dfs.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    static int size;
    static int[][] matrix;
    static int[][] visited;

    static int count = 0;

    static List<Integer> countList = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        setting();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (matrix[row][col] == 1 && visited[row][col] == 0) {

                    count++;
                    visited[row][col] = 1;
                    dfs(row, col);

                    countList.add(count);

                    count = 0;
                }

            }
        }

        countList.sort((count1, count2) -> count1 - count2);


        System.out.println(countList.size());
        for (Integer integer : countList) {
            System.out.println(integer);
        }

    }

    private static void dfs(int row, int col) {

        for (int dir = 0; dir < 4; dir++) {

            int postRow = row + dx[dir];
            int postCol = col + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                visited[postRow][postCol] = 1;

                count++;

                dfs(postRow, postCol);
            }

        }

    }

    private static boolean existAndCanGoCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 1 && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        matrix = new int[size][size];
        visited = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

    }


}
