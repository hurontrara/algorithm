package codeTree.intermediateLow.bfs.section2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1 {

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int rowSize, colSize;
    static int[][] matrix;

    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static int count = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        setting();

        queue.add(new Point(0, 0));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            bfs();
        }

        System.out.println(-1);


    }

    private static void bfs() {

        Point point = queue.poll();
        if (point.x == rowSize - 1 && point.y == colSize - 1) {
            System.out.println(visited[point.x][point.y] - 1);
            System.exit(0);
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

        return (row >= 0 && row < rowSize && col >= 0 && col < colSize && matrix[row][col] == 1 && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        rowSize = sc.nextInt();
        colSize = sc.nextInt();
        matrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        visited = new int[rowSize][colSize];
    }


}
