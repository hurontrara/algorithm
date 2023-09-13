package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    public static int n, m, q;
    public static int[][] matrix;
    public static List<Integer> windRow = new ArrayList<>();
    public static List<String> windDirection = new ArrayList<>();

    public static List<Integer> secondWindRow = new ArrayList<>();
    public static List<String> secondWindHorizon = new ArrayList<>();
    public static List<String> secondWindVertical = new ArrayList<>();


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
            windRow.add(sc.nextInt() - 1);
            windDirection.add(sc.next());
        }


        // 리스트 비어있을 때 까지 ㄱㄱ (반복문)
        while (windRow.size() != 0) {
            windProcess();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void windProcess() {

        int localWindRow = windRow.get(0);
        String localWindDirection = windDirection.get(0);

        push(localWindRow, localWindDirection);

        addLocalWind(localWindRow, localWindDirection);


        while (secondWindRow.size() != 0) {
            secondWindProcess();
        }

        windRow.remove(0);
        windDirection.remove(0);


    }

    private static void secondWindProcess() {

        int localWindRow = secondWindRow.get(0);
        String localHorizon = secondWindHorizon.get(0);
        String localVertical = secondWindVertical.get(0);

        push(localWindRow, localHorizon);

        // 윗 방향이라면, 윗 방향과의 체크 후 추가
        if (localVertical.equals("U")) {
            addUpLocalRow(localWindRow, localHorizon);
        } else {
            addDownLocalRow(localWindRow, localHorizon);
        }

        secondWindRow.remove(0);
        secondWindHorizon.remove(0);
        secondWindVertical.remove(0);
    }



    private static void addLocalWind(int localWindRow, String localWindDirection) {

        addUpLocalRow(localWindRow, localWindDirection);

        addDownLocalRow(localWindRow, localWindDirection);


    }

    private static void addDownLocalRow(int localWindRow, String localWindDirection) {
        if (localWindRow < n - 1) {
            for (int col = 0; col < m; col++) {
                if (matrix[localWindRow][col] == matrix[localWindRow + 1][col]) {

                    secondWindRow.add(localWindRow + 1);

                    if (localWindDirection.equals("L")) {
                        secondWindHorizon.add("R");
                    } else {
                        secondWindHorizon.add("L");
                    }

                    secondWindVertical.add("D");

                    return;
                }
            }
        }
    }

    private static void addUpLocalRow(int localWindRow, String localWindDirection) {
        if (localWindRow >= 1) {
            for (int col = 0; col < m; col++) {
                if (matrix[localWindRow][col] == matrix[localWindRow - 1][col]) {

                    secondWindRow.add(localWindRow - 1);

                    if (localWindDirection.equals("L")) {
                        secondWindHorizon.add("R");
                    } else {
                        secondWindHorizon.add("L");
                    }

                    secondWindVertical.add("U");

                    return;
                }
            }
        }
    }

    private static void push(int localWindRow, String localWindDirection) {


        if (localWindDirection.equals("R")) {

            int localTemp = matrix[localWindRow][0];

            for (int col = 1; col < m; col++) {
                matrix[localWindRow][col - 1] = matrix[localWindRow][col];
            }

            matrix[localWindRow][m - 1] = localTemp;

        } else {

            int localTemp = matrix[localWindRow][m - 1];

            for (int col = m - 1; col > 0; col--) {
                matrix[localWindRow][col] = matrix[localWindRow][col - 1];
            }
            matrix[localWindRow][0] = localTemp;

        }
    }


}
