package codeTree.intermediateLow.backTracking.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    static class Position {
        int x;
        int y;
        int value;

        Position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }


    static int size;
    static int[][] matrix;

    static int firstRow;
    static int firstCol;
    static int lastRow;
    static int lastCol;

    static List<Position> posistionList = new ArrayList<>();
    static List<Position> localList = new ArrayList<>();

    static int finalDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        if (finalDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(finalDistance);
        }

    }

    private static void backTracking(int index, int num) {

        if (index == 3) {

            int distance = 0;
            int localRow = firstRow;
            int localCol = firstCol;

            if (posistionList.get(0).equals(1) && posistionList.get(1).equals(4) && posistionList.get(2).equals(9)) {
                int a = 1;
            }

            for (int i = 0; i < 3; i++) {

                Position position = localList.get(i);

                distance += Math.abs(position.x - localRow) + Math.abs(position.y - localCol);

                localRow = position.x;
                localCol = position.y;
            }

            distance += Math.abs(localRow - lastRow) + Math.abs(localCol - lastCol);

            if (distance < finalDistance) {
                finalDistance = distance;
            }

            return;

        }

        for (int i = num; i < posistionList.size(); i++) {

            localList.add(posistionList.get(i));

            backTracking(index + 1, i + 1);

            localList.remove(localList.size() - 1);

        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size];

        for (int row = 0; row < size; row++) {

            String string = sc.next();

            for (int col = 0; col < size; col++) {
                String value = String.valueOf(string.charAt(col));

                switch (value) {
                    case ".":
                        matrix[row][col] = 0;
                        break;
                    case "S":
                        matrix[row][col] = -1;
                        firstRow = row;
                        firstCol = col;
                        break;
                    case "E":
                        matrix[row][col] = -2;
                        lastRow = row;
                        lastCol = col;
                        break;
                    default:
                        int intValue = Integer.parseInt(value);
                        matrix[row][col] = intValue;
                        posistionList.add(new Position(row, col, intValue));
                }

            }

        }

        posistionList.sort((position1, position2) -> position1.value - position2.value);

    }


}
