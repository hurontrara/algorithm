package codeTree.intermediateLow.simulation.gridMoves;

import java.util.*;

public class Q5 {

    private static class Ball {

        int id;
        int x;
        int y;
        int dir;
        int speed;

        Ball(int id, int x, int y, int dir, int speed) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.speed = speed;
        }
    }

    public static int size, ballNum, time, canBallNum;
    public static int[][] matrix;
    public static List<Ball> ballList = new ArrayList<>();

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        setttings();


        for (int t = 0; t < time; t++) {

            for (int i = 0; i < ballList.size(); i++) {
                move(ballList.get(i));
            }

            // ballList 정렬
            Collections.sort(ballList, new Comparator<Ball>() {
                @Override
                public int compare(Ball ball1, Ball ball2) {
                    if (ball1.speed == ball2.speed) {
                        return ball2.id - ball1.id;
                    }
                    return ball2.speed - ball1.speed;
                }
            });

            // 충돌 처리
            for (int i = ballList.size() - 1; i >= 0; i--) {

                Ball ball = ballList.get(i);
                if (matrix[ball.x][ball.y] > canBallNum) {
                    ballList.remove(i);
                    matrix[ball.x][ball.y] -= 1;
                }

            }


            matrix = new int[size][size];
        }

        System.out.println(ballList.size());





    }

    private static void move(Ball ball) {

        int row = ball.x;
        int col = ball.y;
        int dir = ball.dir;
        int speed = ball.speed;

        for (int t = 0; t < speed; t++) {

            if (!existCheck(row + dx[dir], col + dy[dir])) {
                dir = (dir + 2) % 4;
            }

            row += dx[dir];
            col += dy[dir];

        }

        matrix[row][col] += 1;

        ball.x = row;
        ball.y = col;
        ball.dir = dir;



    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void setttings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); ballNum = sc.nextInt(); time = sc.nextInt(); canBallNum = sc.nextInt();
        matrix = new int[size][size];


        for (int i = 1; i < ballNum + 1; i++) {

            Ball ball = new Ball(i, sc.nextInt() - 1, sc.nextInt() - 1, dirToInt(sc.next()), sc.nextInt());

            ballList.add(ball);

        }


    }

    private static int dirToInt(String str) {

        switch (str) {
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
