package codeTree.intermediateLow.bfs.section1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int size, iterNum;
    static int startRow, startCol;
    static int[][] matrix;

    static Queue<Point> queue = new LinkedList<>();
    static int maxValue = 0;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {

        setting();

        for (int i = 0; i < iterNum; i++) {

            queue.add(new Point(startRow, startCol));
            int value = matrix[startRow][startCol];
            while (!queue.isEmpty()) {
                bfs(value);
            }

            if (maxValue == 0) {
                System.out.println((startRow + 1) + " " + (startCol + 1));
                System.exit(0);
            }

            setStartRowAndCol();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    visited[row][col] = 0;
                }
            }
            maxValue = 0;

        }

        System.out.println((startRow + 1) + " " + (startCol + 1));

    }

    private static void setStartRowAndCol() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == maxValue && visited[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                    return;
                }
            }
        }



    }

    private static void bfs(int value) {

        Point point = queue.poll();

        for (int dir = 0; dir < 4; dir++) {
            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol, value)) {

                int localValue = matrix[postRow][postCol];
                if (localValue > maxValue) {
                    maxValue = localValue;
                }
                visited[postRow][postCol] = 1;
                queue.add(new Point(postRow, postCol));

            }
        }

    }

    private static boolean existAndCanGoCheck(int row, int col, int value) {
        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] < value && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); iterNum = sc.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;

        visited = new int[size][size];


    }
}
