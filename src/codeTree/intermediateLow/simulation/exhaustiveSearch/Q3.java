package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.Scanner;

public class Q3 {

    public static int globalRow;
    public static int globalColumn;
    public static int[][] matrix;
    public static int max = 0;
    public static int[] rightBlock = new int[3];

    public static void main(String[] args) {

        // 입력 받기
        Scanner sc = new Scanner(System.in);

        globalRow = sc.nextInt();
        globalColumn = sc.nextInt();
        matrix = new int[globalRow][globalColumn];
        for (int row = 0; row < globalRow; row++) {
            for (int col = 0; col < globalColumn; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }

        // 왼쪽 블럭 로직
        leftBlockLogic();

        // 오른쪽 블럭 로직
        rightBlockLogic();

    }

    private static void rightBlockLogic() {

        // 가로일 때
        for (int row = 0; row < globalRow; row++) {
            for (int col = 0; col < globalColumn; col++) {
                if (col + 2 >= globalColumn) {
                    continue;
                }

                rightBlock[0] = matrix[row][col];
                rightBlock[1] = matrix[row][col+1];
                rightBlock[2] = matrix[row][col+2];

                countRightBlockSum();

            }
        }

        // 세로일 때
        for (int row = 0; row < globalRow; row++) {
            for (int col = 0; col < globalColumn; col++) {
                if (row + 2 >= globalRow) {
                    continue;
                }

                rightBlock[0] = matrix[row][col];
                rightBlock[1] = matrix[row+1][col];
                rightBlock[2] = matrix[row+2][col];

                countRightBlockSum();

            }
        }

        System.out.println(max);


    }

    private static void countRightBlockSum() {
        int localSum = 0;
        for (int i : rightBlock) {
            localSum += i;
        }
        max = Math.max(localSum, max);
    }

    private static void leftBlockLogic() {

        int[] localArray = new int[4];
        for (int row = 0; row < globalRow; row++) {
            for (int col = 0; col < globalColumn; col++) {

                if (row + 1 == globalRow || col + 1 == globalColumn) {
                    continue;
                }

                localArray[0] = matrix[row][col];
                localArray[1] = matrix[row][col + 1];
                localArray[2] = matrix[row + 1][col];
                localArray[3] = matrix[row + 1][col + 1];
                int localSum = localArray[0] + localArray[1] + localArray[2] + localArray[3];


                for (int i = 0; i < localArray.length; i++) {
                    int localAns = localSum - localArray[i];
                    max = Math.max(localAns, max);
                }
            }
        }
    }

}
