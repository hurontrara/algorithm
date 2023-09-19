package codeTree.intermediateLow.simulation.gridMoves;

import java.util.*;


public class Q6 {

    static class Ball {

        int id;
        int x;
        int y;
        int weight;
        int dir;

        Ball(int id, int x, int y, int weight, String dir) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.dir = dirToInt(dir);
        }

        private int dirToInt(String dir) {

            switch (dir) {
                case "R":
                    return 0;
                case "U":
                    return 1;
                case "L":
                    return 2;
                case "D":
                    return 3;
            }

            return -1;

        }

    }

    static Scanner sc = new Scanner(System.in);
    static List<Ball> ballList;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] matrix;
    static int rowSize;
    static int colSize;
    static List<Integer> saveTimeList = new ArrayList<>();



    public static void main(String[] args) {

        int testCaseNum = sc.nextInt();
        for (int i = 0; i < testCaseNum; i++) {

            setting();

            int saveTime = -1;
            for (int time = 1; time <= Math.max(rowSize, colSize); time++) {

                move();

                ballList.sort((ball1, ball2) -> {
                    if (ball2.weight == ball1.weight) {
                        return ball2.id - ball1.id;
                    }
                    return ball2.weight - ball1.weight;
                });

                for (int index = ballList.size() - 1; index >= 0; index--) {

                    Ball ball = ballList.get(index);

                    if (existCheck(ball.x, ball.y) && matrix[ball.x][ball.y] > 1) {
                        ballList.remove(index);
                        matrix[ball.x][ball.y] -= 1;
                        saveTime = time;
                    }

                }

                for (Ball ball : ballList) {
                    if (existCheck(ball.x, ball.y)) {
                        matrix[ball.x][ball.y] = 0;
                    }
                }
            }
            saveTimeList.add(saveTime);

        }

        for (Integer integer : saveTimeList) {
            System.out.println(integer);
        }
    }

    private static void move() {
        for (Ball ball : ballList) {
            ball.x = ball.x + dx[ball.dir];
            ball.y = ball.y + dy[ball.dir];

            if (existCheck(ball.x, ball.y)) {
                matrix[ball.x][ball.y] += 1;
            }
        }
    }

    private static boolean existCheck(int x, int y) {
        return (x >= 0 && x < rowSize && y >= 0 && y < colSize);
    }

    private static void setting() {

        ballList = new ArrayList<>();

        int ballNum = sc.nextInt();

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        List<Integer> weightList = new ArrayList<>();
        List<String> dirList = new ArrayList<>();

        for (int i = 0; i < ballNum; i++) {
            xList.add(sc.nextInt());
            yList.add(sc.nextInt());
            weightList.add(sc.nextInt());
            dirList.add(sc.next());
        }

        Integer rowMin = Collections.min(xList);
        Integer rowMax = Collections.max(xList);
        Integer colMin = Collections.min(yList);
        Integer colMax = Collections.max(yList);

        rowSize = (rowMax - rowMin) * 2 + 1;
        colSize = (colMax - colMin) * 2 + 1;

        matrix = new int[rowSize][colSize];
        for (int i = 0; i < xList.size(); i++) {

            int actualRow = rowSize - 1 - (yList.get(i) - colMin) * 2;
            int actualCol = (xList.get(i) - rowMin) * 2;

            Ball ball = new Ball(i, actualRow, actualCol, weightList.get(i), dirList.get(i));
            ballList.add(ball);
        }

    }



}