package codeTree.intermediateLow.simulation.gridMove;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    public static int size, appleNum, move;
    public static int[][] matrix;
    public static List<Integer> moveList = new ArrayList<>();

    public static int headRow = 0;
    public static int headCol = 0;
    public static int tailNum = 0;
    public static int count = 0;
    public static List<Integer> moveRowLog = new ArrayList<>();
    public static List<Integer> moveColLog = new ArrayList<>();
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {

        settings();

        for (int i = 0; i < moveList.size(); i++) {

            if (!move(i)) {
                break;
            }

            if (!tailSet()) {
                break;
            }

        }

        System.out.println(count);

    }

    private static boolean tailSet() {

        int logLength = moveRowLog.size();

        for (int i = logLength - 1; i > logLength - tailNum - 1; i--) {

            int tailRow = moveRowLog.get(i);
            int tailCol = moveColLog.get(i);

            if (tailRow == headRow && tailCol == headCol) {
                return false;
            }
        }


        return true;


    }

    private static boolean move(int i) {

        count++;
        int dir = moveList.get(i);
        int postRow = headRow + dx[dir];
        int postCol = headCol + dy[dir];

        // 게임 끝인 경우
        if (!existCheck(postRow, postCol)) {
            return false;
        }

        // 사과 있는 경우
        if (matrix[postRow][postCol] == 1) {
            tailNum++;
            matrix[postRow][postCol] = 0;
        }

        moveRowLog.add(headRow);
        moveColLog.add(headCol);

        headRow = postRow;
        headCol = postCol;

        return true;
    }

    private static boolean existCheck(int postRow, int postCol) {
        return (postRow >= 0 && postRow < size && postCol >= 0 && postCol < size);
    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); appleNum = sc.nextInt(); move = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < appleNum; i++) {
            int appleRow = sc.nextInt() - 1;
            int appleCol = sc.nextInt() - 1;
            matrix[appleRow][appleCol] = 1;
        }

        for (int i = 0; i < move; i++) {

            int dir = dirToInt(sc.next());
            int count = sc.nextInt();

            for (int j = 0; j < count; j++) {
                moveList.add(dir);
            }

        }

    }

    private static int dirToInt(String str) {
        if (str.equals("R")) {
            return 0;
        }
        if (str.equals("U")) {
            return 1;
        }
        if (str.equals("L")) {
            return 2;
        }
        return 3;
    }


}
