package codeTree.intermediateLow.bfs.section1;

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

    static class Stone {
        int x;
        int y;

        Stone(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int size, startPointNum, stoneNum;
    static int[][] matrix;

    static List<Point> startPointList = new ArrayList<>();
    static Queue<Point> queue = new LinkedList<>();
    static List<Stone> stoneList = new ArrayList<>();
    static int[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maxCount = 0;
    static int localCount = 0;

    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        System.out.println(maxCount);
    }

    private static void backTracking(int index, int count) {
        if (count == stoneNum) {

            localCount = 0;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    visited[row][col] = 0;
                }
            }
            queueInitialization();


            while (!queue.isEmpty()) {

                bfs();

            }

            if (localCount > maxCount) {
                maxCount = localCount;
            }


            return;

        }

        for (int i = index; i < stoneList.size(); i++) {

            Stone stone = stoneList.get(i);
            matrix[stone.x][stone.y] = 0;

            backTracking(i + 1, count + 1);

            matrix[stone.x][stone.y] = 1;


        }


    }

    private static void bfs() {
        Point point = queue.poll();
        for (int dir = 0; dir < 4; dir++) {
            int postRow = point.x + dx[dir];
            int postCol = point.y + dy[dir];

            if (existAndCanGoCheck(postRow, postCol)) {
                queue.add(new Point(postRow, postCol));
                visited[postRow][postCol] = 1;
                localCount++;
            }
        }
    }

    private static boolean existAndCanGoCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && matrix[row][col] == 0 && visited[row][col] == 0);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); startPointNum = sc.nextInt(); stoneNum = sc.nextInt();
        matrix = new int[size][size];
        visited = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = sc.nextInt();
                matrix[i][j] = value;
                if (value == 1) {
                    stoneList.add(new Stone(i, j));
                }
            }
        }

        for (int i = 0; i < startPointNum; i++) {

            startPointList.add(new Point(sc.nextInt() - 1, sc.nextInt() - 1));

        }

    }

    private static void queueInitialization() {

        queue.addAll(startPointList);

        for (Point point : queue) {
            visited[point.x][point.y] = 1;
            localCount++;
        }

    }


}
