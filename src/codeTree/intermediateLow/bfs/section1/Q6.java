package codeTree.intermediateLow.bfs.section1;

import java.util.*;

public class Q6 {

    static class Point {

        int x;
        int y;
        int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }


    static int size, cityNum, up, down;
    static int[][] matrix;

    static List<Point> pointList = new ArrayList<>();
    static List<Point> localPointList = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();

    static int globalCount;
    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maxCount = 0;

    public static void main(String[] args) {

        setting();

        backTracking(0, 0);

        System.out.println(maxCount);

    }

    private static void backTracking(int index, int count) {

        if (count == cityNum) {

            bfsSetting();

            while (!queue.isEmpty()) {

                bfs();

            }

            if (globalCount > maxCount) {
                maxCount = globalCount;
            }

            return;


        }

        for (int i = index; i < pointList.size(); i++) {

            localPointList.add(pointList.get(i));

            backTracking(i + 1, count + 1);

            localPointList.remove(localPointList.size() - 1);

        }

    }

    private static void bfs() {

        Point point = queue.poll();
        int value = point.value;
        for (int dir = 0; dir < 4; dir++) {

            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol, value)) {
                globalCount++;
                visited[postRow][postCol] = 1;
                queue.add(new Point(postRow, postCol, matrix[postRow][postCol]));
            }
        }


    }

    private static boolean existAndCanGoCheck(int row, int col, int value) {

        return (row >= 0 && row < size && col >= 0 && col < size && Math.abs(value - matrix[row][col]) >= up && Math.abs(value - matrix[row][col]) <= down && visited[row][col] == 0);
    }

    private static void bfsSetting() {

        queue.addAll(localPointList);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                visited[row][col] = 0;
            }
        }

        for (Point point : localPointList) {
            visited[point.x][point.y] = 1;
        }

        globalCount = localPointList.size();

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); cityNum = sc.nextInt(); up = sc.nextInt(); down = sc.nextInt();
        matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = sc.nextInt();
                matrix[row][col] = value;
                pointList.add(new Point(row, col, value));
            }
        }

        visited = new int[size][size];

    }
}
