package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.Scanner;

public class Q1 {

    public static int size;
    public static int[][] matrix;

    public static void main(String[] args) {

        // 숫자 받기
        // 매트릭스 설정
        // 매트릭스 값 채우기
        // 탐색

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = sc.nextInt();
                
            }            
        }

        int maxGold = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                if (row + 2 >= size || col + 2 >= size) {
                    continue;
                }

                int localGold = getNumOfGold(row, col);

                maxGold = Math.max(localGold, maxGold);
            }
            
        }

        System.out.println(maxGold);
    }

    private static int getNumOfGold(int row, int col) {
        int localGold = 0;

        for (int gridRow = row; gridRow <= row + 2; gridRow++) {
            for (int gridCol = col;  gridCol <= col + 2; gridCol++) {
                localGold += matrix[gridRow][gridCol];
            }
        }

        return localGold;
    }
}