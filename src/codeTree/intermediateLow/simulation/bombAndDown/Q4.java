package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    public static int[][] matrix = new int[4][4];
    public static String dir;
    public static void main(String[] args) {

        settings();

        for (int i = 0; i < 4; i++) {

            List<Integer> localList = getLocalList(i);

            List<Integer> sortedList = sortProcess(localList);

            List<Integer> finalList = sortProcess(sumProcess(sortedList));

            saveMatrix(i, finalList);


        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void saveMatrix(int i, List<Integer> finalList) {

        if (dir.equals("R") || dir.equals("L")) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = finalList.get(j);
            }
        } else {
            for (int j = 0; j < 4; j++) {
                matrix[j][i] = finalList.get(j);
            }
        }

    }

    private static List<Integer> sortProcess(List<Integer> localList) {

        // 밀기 (0 제거)
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> nonZeroList = new ArrayList<>();

        for (int i = 0; i < localList.size(); i++) {
            if (localList.get(i).equals(0)) {
                zeroList.add(0);
            } else {
                nonZeroList.add(localList.get(i));
            }
        }

        localList = new ArrayList<>();


        if (dir.equals("R") || dir.equals("D")) {

            zeroList.addAll(nonZeroList);

            return zeroList;

        } else {

            nonZeroList.addAll(zeroList);


            return nonZeroList;

        }

    }


    private static List<Integer> sumProcess(List<Integer> localList) {

        // 밀기 (0 제거)
        if (dir.equals("R") || dir.equals("D")) {

            for (int i = 3; i > 0; i--) {
                if (localList.get(i).equals(localList.get(i - 1))) {
                    localList.set(i, localList.get(i) * 2);
                    localList.set(i - 1, 0);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (localList.get(i).equals(localList.get(i + 1))) {
                    localList.set(i, localList.get(i) * 2);
                    localList.set(i + 1, 0);
                }
            }
        }

        return localList;

    }

    private static List<Integer> getLocalList(int i) {

        List<Integer> localArray = new ArrayList<>();

        for (int j = 0; j < 4; j++) {

            if (dir.equals("R") || dir.equals("L")) {
                localArray.add(matrix[i][j]);
            } else {
                localArray.add(matrix[j][i]);
            }

        }

        return localArray;
    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dir = sc.next();

    }


}
