package codeTree.intermediateLow.bfs.section2;

import java.util.*;

public class Q4 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int size, brakeNum;
    static int[][] matrix;
    static int startRow, startCol, endRow, endCol;

    static List<Point> pointList = new ArrayList<>();
    static List<Point> localList = new ArrayList<>();
    static int[][] visited;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Integer> endPointList = new ArrayList<>();


    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        if (endPointList.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(endPointList));
        }

    }

    private static void backTracking(int index, int count) {

        if (count == brakeNum) {

            brake();

            bfsProcess();

            recover();

        }

        for (int i = index; i < pointList.size(); i++) {

            localList.add(pointList.get(i));

            backTracking(i + 1, count + 1);

            localList.remove(localList.size() - 1);

        }

    }

    private static void bfsProcess() {

        queue.add(new Point(startRow, startCol));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                visited[i][j] = 0;
            }
        }
        visited[startRow][startCol] = 1;

        while (!queue.isEmpty()) {
            bfs();
        }



    }

    private static void bfs() {
        Point point = queue.poll();

        if (point.x == endRow && point.y == endCol) {
            endPointList.add(visited[point.x][point.y] - 1);
            queue.clear();
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
        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0);
    }

    private static void recover() {
        for (Point point : localList) {
            matrix[point.x][point.y] = 1;
        }
    }

    private static void brake() {
        for (Point point : localList) {
            matrix[point.x][point.y] = 0;
        }
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); brakeNum = sc.nextInt();
        matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                int value = sc.nextInt();
                matrix[row][col] = value;

                if (value == 1) {
                    pointList.add(new Point(row, col));
                }

            }
        }
        startRow = sc.nextInt() - 1; startCol = sc.nextInt() - 1; endRow = sc.nextInt() - 1; endCol = sc.nextInt() - 1;

        visited = new int[size][size];

    }


}
