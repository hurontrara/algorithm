package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    public static int n, m, q;
    public static int[][] matrix;
    public static List<Integer> firstRow = new ArrayList<>();
    public static List<Integer> firstColumn = new ArrayList<>();
    public static List<Integer> lastRow = new ArrayList<>();
    public static List<Integer> lastColumn = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {
            firstRow.add(sc.nextInt() - 1);
            firstColumn.add(sc.nextInt() - 1);
            lastRow.add(sc.nextInt() - 1);
            lastColumn.add(sc.nextInt() - 1);
        }

        for (int i = 0; i < q; i++) {
            rotationProcess();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void rotationProcess() {

        int[][] localMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                localMatrix[i][j] = matrix[i][j];
            }
        }

        Integer localFirstRow = firstRow.get(0);
        Integer localFirstCol = firstColumn.get(0);
        Integer localLastRow = lastRow.get(0);
        Integer localLastCol = lastColumn.get(0);


        for (int row = localFirstRow; row < localLastRow + 1; row++) {
            for (int col = localFirstCol; col < localLastCol + 1; col++) {

                // 1. 밑에껄 받는 케이스
                if (row != localLastRow && col == localFirstCol) {
                    localMatrix[row][col] = matrix[row + 1][col];
                }
                // 2. 왼쪽껄 받는 케이스
                if (row == localFirstRow && col != localFirstCol) {
                    localMatrix[row][col] = matrix[row][col - 1];
                }
                // 3. 위에껄 받는 케이스
                if (row != localFirstRow && col == localLastCol) {
                    localMatrix[row][col] = matrix[row - 1][col];
                }
                // 4. 오른쪽꺼 받는 케이스
                if (row == localLastRow && col != localLastCol) {
                    localMatrix[row][col] = matrix[row][col + 1];
                }


            }
        }

        matrix = localMatrix;

        meanProcess(localFirstRow, localFirstCol, localLastRow, localLastCol);


    }

    private static void meanProcess(Integer localFirstRow, Integer localFirstCol, Integer localLastRow, Integer localLastCol) {

        int[][] localMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                localMatrix[i][j] = matrix[i][j];
            }
        }

        for (int row = localFirstRow; row < localLastRow + 1; row++) {
            for (int col = localFirstCol; col < localLastCol + 1; col++) {

                int sum = matrix[row][col];
                int count = 1;
                if (existCheck(row, col - 1)) {
                    sum += matrix[row][col - 1];
                    count++;
                }
                if (existCheck(row - 1, col)) {
                    sum += matrix[row - 1][col];
                    count++;
                }
                if (existCheck(row, col + 1)) {
                    sum += matrix[row][col + 1];
                    count++;
                }
                if (existCheck(row + 1, col)) {
                    sum += matrix[row + 1][col];
                    count++;
                }

                localMatrix[row][col] = sum / count;

            }
        }

        matrix = localMatrix;

        firstRow.remove(0);
        firstColumn.remove(0);
        lastRow.remove(0);
        lastColumn.remove(0);



    }

    private static boolean existCheck(int row, int col) {

        return (row >= 0 && row <= n - 1 && col >= 0 && col <= m - 1);
    }

}
