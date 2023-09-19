package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    static int size;
    static int[][] matrix;

    static List<Integer> rowList = new ArrayList<>();
    static List<Integer> colList = new ArrayList<>();

    static List<Integer> boomList = new ArrayList<>();

    static int[] oneDx = {-2, -1, 1, 2};
    static int[] oneDy = {0, 0, 0, 0};

    static int[] twoDx = {-1, 1, 0, 0};
    static int[] twoDy = {0, 0, -1, 1};

    static int[] threeDx = {-1, -1, 1, 1};
    static int[] threeDy = {-1, 1, -1, 1};

    static int[][] dxArray = new int[3][4];
    static int[][] dyArray = new int[3][4];

    static int maxCount = -1;

    public static void main(String[] args) {

        setting();

        backTracking(0);

        System.out.println(maxCount);

    }

    private static void backTracking(int index) {

        if (index == rowList.size()) {
            boomProcess();
            return;
        }

        for (int value = 0; value < 3; value++) {
            boomList.add(value);
            backTracking(index + 1);
            boomList.remove(boomList.size() - 1);
        }
    }

    private static void boomProcess() {


        for (int i = 0; i < rowList.size(); i++) {

            int row = rowList.get(i);
            int col = colList.get(i);
            int boomNum = boomList.get(i);

            matrix[row][col] = 2;
            for (int dir = 0; dir < 4; dir++) {

                int postRow = row + dxArray[boomNum][dir];
                int postCol = col + dyArray[boomNum][dir];

                if (existCheck(postRow, postCol)) {
                    matrix[postRow][postCol] = 2;
                }

            }


        }

        int localCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 2) {
                    localCount++;
                    matrix[row][col] = 0;
                }
            }
        }
        if (localCount > maxCount) {
            maxCount = localCount;
        }


    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = sc.nextInt();
                matrix[row][col] = value;
                if (value == 1) {
                    rowList.add(row);
                    colList.add(col);
                }
            }
        }

        dxArray[0] = oneDx;
        dxArray[1] = twoDx;
        dxArray[2] = threeDx;
        dyArray[0] = oneDy;
        dyArray[1] = twoDy;
        dyArray[2] = threeDy;

    }


}
