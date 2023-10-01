package codeTree.intermediateLow.bfs.section2;

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
    static int startRow, startCol, endRow, endCol;
    static int[][] matrix;

    static Queue<Point> queue = new LinkedList<>();
    static int[][] visited;
    static int count = 1;

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {

        setting();

        visited[startRow][startCol] = 1;
        queue.add(new Point(startRow, startCol));

        while (!queue.isEmpty()) {
            bfs();
        }

        System.out.println(-1);


    }

    private static void bfs() {

        Point point = queue.poll();

        if (point.x == endRow && point.y == endCol) {
            System.out.println(visited[point.x][point.y] - 1);
            System.exit(0);
        }


        for (int dir = 0; dir < 8; dir++) {

            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                visited[postRow][postCol] = visited[point.x][point.y] + 1;
                queue.add(new Point(postRow, postCol));


            }


        }


    }

    private static boolean existAndCanGoCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];
        visited = new int[size][size];

        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;
        endRow = sc.nextInt() - 1;
        endCol = sc.nextInt() - 1;


    }


}
