package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    static class Line {
        int row;
        int col;

        Line(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int colNum;
    static int rowNum;

    static List<Line> lineList = new ArrayList<>();

    static List<Line> localLineList = new ArrayList<>();

    static int[] initialState;
    static int[] targetState;

    static int minRowNum;

    public static void main(String[] args) {

        setting();

        for (int value = 0; value < rowNum; value++) {

            for (int index = 2; index <= rowNum; index++) {
                backTracking(value, index);
            }

        }

        System.out.println(minRowNum);

    }

    private static void backTracking(int value, int index) {

        if (localLineList.size() == index) {
            checkProcess();
        }

        for (int i = value; i < lineList.size(); i++) {

            localLineList.add(lineList.get(value));

            backTracking(i + 1, index);

            localLineList.remove(localLineList.size() - 1);

        }


    }

    private static void checkProcess() {
        List<Line> checkLineList = new ArrayList<>(lineList);

        int[] checkInitialState = new int[colNum];
        for (int i = 0; i < checkInitialState.length; i++) {
            checkInitialState[i] = initialState[i];
        }

        checkLineList.removeAll(localLineList);

        // checkLineList 는 정렬되어 있는 상태
        for (Line line : checkLineList) {
            int col = line.col; // 0
            int temp = checkInitialState[col]; // 앞에껄 세이브
            checkInitialState[col] = checkInitialState[col + 1];
            checkInitialState[col + 1] = temp;
        }

        for (int i = 0; i < checkInitialState.length; i++) {
            if (checkInitialState[i] != targetState[i]) {
                return;
            }
        }

        if (checkLineList.size() < minRowNum) {
            minRowNum = checkLineList.size();
        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        colNum = sc.nextInt(); rowNum = sc.nextInt(); minRowNum = rowNum;
        for (int i = 0; i < rowNum; i++) {
            int col = sc.nextInt() - 1;
            int row = sc.nextInt() - 1;
            Line line = new Line(row, col);
            lineList.add(line);
        }

        initialState = new int[colNum];
        for (int i = 0; i < colNum; i++) {
            initialState[i] = i;
        }

        targetState = new int[colNum];
        for (int i = 0; i < initialState.length; i++) {
            targetState[i] = initialState[i];
        }

        lineList.sort((line1, line2) -> line1.row - line2.row);
        for (Line line : lineList) {
            int col = line.col; // 0
            int temp = targetState[col]; // 앞에껄 세이브
            targetState[col] = targetState[col + 1];
            targetState[col + 1] = temp;
        }

    }


}
