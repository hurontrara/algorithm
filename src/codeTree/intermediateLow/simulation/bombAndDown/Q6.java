package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    public static int size, bombNum, rotationNum;
    public static int[][] matrix;

    public static int dy = 1;

    public static void main(String[] args) {

        settings();

        for (int i = 0; i < rotationNum; i++) {

            while (bombProcess()) {
                gravityProcess();
            };


            rotationProcess();

            gravityProcess();

        }

        while (bombProcess()) {
            gravityProcess();
        };

        int stack = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) {
                    stack++;
                }
            }
        }
        System.out.println(stack);


    }

    private static void rotationProcess() {

        int[][] rotationMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotationMatrix[j][size - 1 - i] = matrix[i][j];
            }
        }

        matrix = rotationMatrix;


    }

    private static void gravityProcess() {

        for (int col = 0; col < size; col++) {

            List<Integer> zeroList = new ArrayList<>();
            List<Integer> nonZeroList = new ArrayList<>();
            for (int row = 0; row < size; row++) {
                if (matrix[row][col] == 0) {
                    zeroList.add(0);
                } else {
                    nonZeroList.add(matrix[row][col]);
                }
            }

            zeroList.addAll(nonZeroList);
            for (int row = 0; row < size; row++) {
                matrix[row][col] = zeroList.get(row);
            }

        }


    }

    private static boolean bombProcess() {

        boolean works = false;
        int[][] localMatrix = new int[size][size];

        for (int i = 0; i < size - (bombNum - 1); i++) {
            for (int j = 0; j < size; j++) {

                int value = matrix[i][j];
                if (value == 0) {
                    continue;
                }

                int stack = 0;
                for (int k = 0; k < bombNum; k++) {
                    if (matrix[i + dy * k][j] == value) {
                        stack++;
                    }
                }


                if (stack == bombNum) {
                    for (int k = 0; k < bombNum; k++) {
                        localMatrix[i + dy * k][j] = 1;
                        works = true;
                    }
                }

            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (localMatrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }


        return works;
    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size]; bombNum = sc.nextInt(); rotationNum = sc.nextInt();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

}
