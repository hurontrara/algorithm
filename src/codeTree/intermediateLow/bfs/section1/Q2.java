package codeTree.intermediateLow.bfs.section1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int size;
    static int pointNum;
    static int[][] matrix;

    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        setting();

        while (!queue.isEmpty()) {

            bfs();

        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count += visited[i][j];
            }
        }

        System.out.println(count);


    }

    private static void bfs() {

        Point point = queue.poll();

        for (int dir = 0; dir < 4; dir++) {

            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                queue.add(new Point(postRow, postCol));
                visited[postRow][postCol] = 1;
            }

        }


    }

    private static boolean existAndCanGoCheck(int row, int col) {

        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0);

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); pointNum = sc.nextInt();
        matrix = new int[size][size];
        visited = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < pointNum; i++) {

            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            queue.add(new Point(row, col));
            visited[row][col] = 1;
        }


    }
}
