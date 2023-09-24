package codeTree.intermediateLow.dfs.section1;

import java.util.Scanner;

public class Q1 {

    static int size;
    static int[][] matrix;

    static int edgeNum;

    static int[] visited;
    static int maxCount = 0;

    public static void main(String[] args) {

        setting();

        dfs(0);

        int count = 0;
        for (int i : visited) {
            count += i;
        }

        System.out.println(count - 1);

    }

    private static void dfs(int row) {


        for (int col = 0; col < size; col++) {

            if (matrix[row][col] == 1 && visited[col] == 0) {

                visited[col] = 1;
                dfs(col);

            }

        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        edgeNum = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < edgeNum; i++) {

            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            matrix[row][col] = 1;
            matrix[col][row] = 1;
        }

        visited = new int[size];
        visited[0] = 1;
    }


}
