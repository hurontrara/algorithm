package codeTree.intermediateLow.bfs.section2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q6 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int size;
    static int[][] matrix;

    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        setting();

        bfsProcess();
    }

    private static void bfsProcess() {

        queue.forEach(point -> visited[point.x][point.y] = 1);

        while (!queue.isEmpty()) {
            bfs();
        }

        visitedOutput();

    }

    private static void visitedOutput() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (visited[row][col] != 0) {
                    System.out.print(visited[row][col] - 1 + " ");
                    continue;
                }

                if (matrix[row][col] == 0) {
                    System.out.print(-1 + " ");
                    continue;
                }

                System.out.print(-2 + " ");


            }

            System.out.println();
        }
    }

    private static void bfs() {

        Point point = queue.poll();

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

        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 1 && visited[row][col] == 0);

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();

                if (matrix[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        visited = new int[size][size];


    }


}
