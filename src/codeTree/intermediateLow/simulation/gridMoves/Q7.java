package codeTree.intermediateLow.simulation.gridMoves;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q7 {

    static class Ball {

        int id;
        int x;
        int y;
        int dir;
        int weight;

        Ball(int id, int x, int y, String dir, int weight) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dir = dirToInt(dir);
            this.weight = weight;
        }

        private int dirToInt(String dir) {
            switch (dir) {
                case ("R"):
                    return 0;
                case ("U"):
                    return 1;
                case ("L"):
                    return 2;
                case ("D"):
                    return 3;
            }
            return -1;
        }

    }

    static int size, ballNum, time;
    static int[][] matrix;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static List<Ball> ballList = new ArrayList<>();
    static int[][] saveMatrix;


    public static void main(String[] args) {
        setting();


        for (int t = 0; t < time; t++) {

            moveOrChangeDir();

            summingBall();

        }

        System.out.print(ballList.size() + " ");
        int maxWeight = -1;
        for (Ball ball : ballList) {
            if (ball.weight > maxWeight) {
                maxWeight = ball.weight;
            }
        }
        System.out.print(maxWeight);

    }

    private static void summingBall() {

        ballList.sort((ball1, ball2) -> ball1.id - ball2.id);

        List<Ball> removeBallList = new ArrayList<>();
        for (Ball ball : ballList) {

            if (matrix[ball.x][ball.y] > 1) {
                removeBallList.add(ball);
                saveMatrix[ball.x][ball.y] += ball.weight;
                matrix[ball.x][ball.y] -= 1;
                continue;
            }

            ball.weight += saveMatrix[ball.x][ball.y];
            saveMatrix[ball.x][ball.y] = 0;

        }

        ballList.removeAll(removeBallList);
        for (Ball ball : ballList) {
            matrix[ball.x][ball.y] = 0;
        }

    }

    private static void moveOrChangeDir() {

        for (Ball ball : ballList) {

            int postRow = ball.x + dx[ball.dir];
            int postCol = ball.y + dy[ball.dir];

            if (!existCheck(postRow, postCol)) {
                ball.dir = (ball.dir + 2) % 4;
                matrix[ball.x][ball.y] += 1;
                continue;
            }

            ball.x = postRow;
            ball.y = postCol;
            matrix[ball.x][ball.y] += 1;


        }

    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt(); ballNum = sc.nextInt(); time = sc.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < ballNum; i++) {

            Ball ball = new Ball(i, sc.nextInt() - 1, sc.nextInt() - 1, sc.next(), sc.nextInt());
            ballList.add(ball);

            }
        saveMatrix = new int[size][size];
        }


    }



