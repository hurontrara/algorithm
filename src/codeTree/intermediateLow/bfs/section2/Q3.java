package codeTree.intermediateLow.bfs.section2;

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

    static int size, h, m;
    static int[][] matrix;

    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] personMatrix;

    static boolean find;

    public static void main(String[] args) {

        setting();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                bfsProcess(row, col);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 2 && personMatrix[i][j] == 0) {
                    personMatrix[i][j] = -1;
                }

                System.out.print(personMatrix[i][j] + " ");
            }
            System.out.println();
        }




    }

    private static void bfsProcess(int row, int col) {

        if (!(matrix[row][col] == 2)) {
            return;
        }

        visited[row][col] = 1;
        queue.add(new Point(row, col));

        while (!queue.isEmpty()) {
            bfs(row, col);
        }

    }

    private static void bfs(int row, int col) {

        Point point = queue.poll();

        if (matrix[point.x][point.y] == 3) {

            personMatrix[row][col] = visited[point.x][point.y] - 1;
            queue.clear();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    visited[i][j] = 0;
                }
            }

            return;
        }

        for (int dir = 0; dir < 4; dir++) {

            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                visited[postRow][postCol] = visited[point.x][point.y] + 1;
                queue.add(new Point(postRow, postCol));
            }

        }

    }

    private static boolean existAndCanGoCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] != 1 && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); h = sc.nextInt(); m = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        visited = new int[size][size];
        personMatrix = new int[size][size];
    }
}
