package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    public static int size, count;
    public static int[] matrix;

    public static List<Integer> processList = new ArrayList<>();
    public static boolean end = false;


    public static void main(String[] args) {

        settings();

        while (!end) {
            boomProcess();
        }

        System.out.println(matrix.length);
        for (int i : matrix) {
            System.out.println(i);
        }
    }

    private static void boomProcess() {

        // 리스트에 숫자로서 추가
        int value = matrix[0];
        processList.add(1);

        for (int i = 1; i < size; i++) {
            if (matrix[i] == value) {
                processList.set(processList.size() - 1, processList.get(processList.size() - 1) + 1);
            } else {
                processList.add(1);
                value = matrix[i];
            }

        }

        // 0으로 바꾸기
        int index = 0;
        int zeroCount = 0;
        for (int i = 0; i < processList.size(); i++) {
            if (processList.get(i) >= count) {
                for (int j = index; j < index + processList.get(i); j++) {
                    matrix[j] = 0;
                    zeroCount++;
                }
            }
            index += processList.get(i);
        }


        // 새로운 matrix 만들기
        int[] newMatrix = new int[matrix.length - zeroCount];

        int matrixIndex = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[i] != 0) {
                newMatrix[matrixIndex] = matrix[i];
                matrixIndex++;
            }
        }

        // 다시 사용할 수 있도록 초기화
        if (newMatrix.length == matrix.length || newMatrix.length == 0) {
            end = true;
        }
        size = newMatrix.length;
        matrix = newMatrix;
        processList = new ArrayList<>();


    }

    private static void settings() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        count = sc.nextInt();
        matrix = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }
    }


}
