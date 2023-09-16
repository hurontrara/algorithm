package codeTree.intermediateLow.simulation.gridMove;

import java.util.Scanner;

public class Q4 {

    public static int size, count, row, col;
    public static int[][] matrix;
    public static int[] rotation;

    public static int up, left, front, behind, right, down;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        settings();

        for (int i = 0; i < count; i++) {
            rollingDice(rotation[i]);
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count += matrix[i][j];
            }
        }
        System.out.println(count);



    }

    private static void rollingDice(int dir) {

        if (!existCheck(row + dx[dir], col + dy[dir])) {
            return;
        }

        // 주사위 상태 결정
        if (dir == 0) {
            righten();
        } else if (dir == 1) {
            upen();
        } else if (dir == 2) {
            leften();
        } else {
            downen();
        }

        matrix[row + dx[dir]][col + dy[dir]] = down;
        row += dx[dir];
        col += dy[dir];

    }

    private static void righten() {

        int localUp, localLeft, localFront, localBehind, localRight, localDown;

        localUp = left;
        localLeft = down;
        localFront = front;
        localBehind = behind;
        localRight = up;
        localDown = right;

        up = localUp; left = localLeft; front = localFront; behind = localBehind; right = localRight; down = localDown;

    }

    private static void upen() {

        int localUp, localLeft, localFront, localBehind, localRight, localDown;

        localUp = front;
        localLeft = left;
        localFront = down;
        localBehind = up;
        localRight = right;
        localDown = behind;

        up = localUp; left = localLeft; front = localFront; behind = localBehind; right = localRight; down = localDown;

    }

    private static void leften() {

        int localUp, localLeft, localFront, localBehind, localRight, localDown;

        localUp = right;
        localLeft = up;
        localFront = front;
        localBehind = behind;
        localRight = down;
        localDown = left;

        up = localUp; left = localLeft; front = localFront; behind = localBehind; right = localRight; down = localDown;

    }

    private static void downen() {

        int localUp, localLeft, localFront, localBehind, localRight, localDown;

        localUp = behind;
        localLeft = left;
        localFront = up;
        localBehind = down;
        localRight = right;
        localDown = front;

        up = localUp; left = localLeft; front = localFront; behind = localBehind; right = localRight; down = localDown;

    }




    private static boolean existCheck(int i, int j) {
        return (i >= 0 && i < size && j >= 0 && j < size);
    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); count = sc.nextInt(); row = sc.nextInt() - 1; col = sc.nextInt() - 1;
        matrix = new int[size][size];
        rotation = new int[count];
        for (int i = 0; i < count; i++) {
            String dirString = sc.next();
            if (dirString.equals("R")) {
                rotation[i] = 0;
            } else if (dirString.equals("U")) {
                rotation[i] = 1;
            } else if (dirString.equals("L")) {
                rotation[i] = 2;
            } else {
                rotation[i] = 3;
            }
        }

        up = 1; left = 4; front = 2; behind = 5; right = 3; down = 6;

        matrix[row][col] = 6;




    }


}
