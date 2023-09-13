package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    public static int size;
    public static int[][] matrix;
    public static int initialRow, initialCol;
    public static int m1, m2, m3, m4, dir;

    public static int[] dx = new int[]{-1, -1, 1, 1, -1, -1, 1, 1};
    public static int[] dy = new int[]{1, -1, -1, 1, -1, 1, 1, -1};
    public static List<Integer> collectValue = new ArrayList<>();
    public static List<Integer> collectRow = new ArrayList<>();
    public static List<Integer> collectCol = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        initialRow = sc.nextInt() - 1; initialCol = sc.nextInt() - 1;
        m1 = sc.nextInt(); m2 = sc.nextInt(); m3 = sc.nextInt(); m4 = sc.nextInt(); dir = sc.nextInt();

        collectProcess();

        sortProcess();

        pasteProcess();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void pasteProcess() {

        for (int i = 0; i < collectValue.size(); i++) {
            matrix[collectRow.get(i)][collectCol.get(i)] = collectValue.get(i);
        }

    }

    private static void sortProcess() {

        // 반시계

        int temp = collectValue.get(collectValue.size() - 1);
        for (int i = collectValue.size() - 1; i > 0; i--) {
            collectValue.set(i, collectValue.get(i - 1));
        }
        collectValue.set(0, temp);

    }

    private static void collectProcess() {

        // 초깃값

        // 반시계
        if (dir == 0) {
            for (int i = 0; i < m1; i++) {
                move(0);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m2; i++) {
                move(1);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m3; i++) {
                move(2);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m4; i++) {
                move(3);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }

        } else {

            for (int i = 0; i < m4; i++) {
                move(4);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m3; i++) {
                move(5);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m2; i++) {
                move(6);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
            for (int i = 0; i < m1; i++) {
                move(7);
                collectValue.add(matrix[initialRow][initialCol]);
                collectRow.add(initialRow);
                collectCol.add(initialCol);
            }
        }



    }

    private static void move(int i) {
        initialRow += dx[i];
        initialCol += dy[i];
    }

}
