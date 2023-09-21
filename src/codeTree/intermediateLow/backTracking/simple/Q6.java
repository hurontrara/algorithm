package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    static int size, m, c;
    static int[][] matrix;

    static List<Integer> list = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    static int maxValue = 0;
    static int finalValue = 0;

    public static void main(String[] args) {

        setting();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= size - m; col++) {

                for (int secondRow = 0; secondRow < size; secondRow++) {
                    for (int secondCol = col; secondCol <= size - m; secondCol++) {

                        if ((secondRow == row) && (col + m - 1 >= secondCol)) {
                            continue;
                        }

                        maxValue = 0;
                        for (int i = 0; i < m; i++) {
                            backTracking(row, col, i);
                        }
                        int savedValue = maxValue;

                        maxValue = 0;
                        for (int i = 0; i < m; i++) {
                            backTracking(secondRow, secondCol, i);
                        }

//                        maxValue = 0;
//                        if (row == 0 && secondRow == 2) {
//                            backTracking(row, col, 0);
//                        }

                        if (savedValue + maxValue > finalValue) {
                            finalValue = savedValue + maxValue;
                        }


                    }
                }

            }
        }

        System.out.println(finalValue);






    }

    private static void backTracking(int row, int col, int index) {

        if (list.stream().mapToInt(Integer::intValue).sum() > c) {
            return;
        }

        if (index == m) {
            int localValue = 0;

            for (Integer integer : list) {
                localValue += Math.pow(integer, 2);
            }

            if (localValue > maxValue) {
                maxValue = localValue;
            }

            return;

        }



        list.add(matrix[row][col + index]);

        for (int j = index + 1; j <= m; j++) {
            backTracking(row, col, j);
        }

        list.remove(list.size() - 1);


    }



    private static void setting() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

    }
}
