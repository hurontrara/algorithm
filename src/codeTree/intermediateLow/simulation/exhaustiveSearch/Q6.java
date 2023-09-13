package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.Scanner;

public class Q6 {

    public static int row;
    public static int column;
    public static int[][] matrix;
    public static int max = -1000000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        column = sc.nextInt();
        matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }


        for (int oneFirstRow = 0; oneFirstRow < row; oneFirstRow++) {
            for (int oneFirstCol = 0; oneFirstCol < column; oneFirstCol++) {
                for (int oneLastRow = oneFirstRow; oneLastRow < row; oneLastRow++) {
                    for (int oneLastCol = oneFirstCol; oneLastCol < column; oneLastCol++) {
                        for (int twoFirstRow = 0; twoFirstRow < row; twoFirstRow++) {
                            for (int twoFirstCol = 0; twoFirstCol < column; twoFirstCol++) {
                                for (int twoLastRow = twoFirstRow; twoLastRow < row; twoLastRow++) {
                                    for (int twoLastCol = twoFirstCol; twoLastCol < column; twoLastCol++) {
                                        rectangleProcess(oneFirstRow, oneFirstCol, oneLastRow, oneLastCol, twoFirstRow, twoFirstCol, twoLastRow, twoLastCol);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);


    }

    private static void rectangleProcess(int oneFirstRow, int oneFirstCol, int oneLastRow, int oneLastCol, int twoFirstRow, int twoFirstCol, int twoLastRow, int twoLastCol) {

        int[][] localMatrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                localMatrix[i][j] = matrix[i][j];
            }
        }


        int localValue = 0;

        for (int i = oneFirstRow; i < oneLastRow + 1; i++) {
            for (int j = oneFirstCol; j < oneLastCol + 1; j++) {
                localValue += localMatrix[i][j];
                localMatrix[i][j] = -10000000;
            }
        }

        for (int i = twoFirstRow; i < twoLastRow + 1; i++) {
            for (int j = twoFirstCol; j < twoLastCol + 1; j++) {
                localValue += localMatrix[i][j];
            }
        }

        max = Math.max(localValue, max);

    }
}
