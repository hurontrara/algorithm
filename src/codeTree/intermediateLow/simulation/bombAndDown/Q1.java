package codeTree.intermediateLow.simulation.bombAndDown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    public static int size;
    public static int[] matrix;
    public static int[] one = new int[2];
    public static int[] two = new int[2];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); matrix = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }
        one[0] = sc.nextInt() - 1; one[1] = sc.nextInt() - 1; two[0] = sc.nextInt() - 1; two[1] = sc.nextInt() - 1;

        int[] afterOne = dropProcess(matrix, one);
        int[] afterTwo = dropProcess(afterOne, two);

        System.out.println(afterTwo.length);
        for (int i : afterTwo) {
            System.out.println(i);
        }
    }

    private static int[] dropProcess(int[] matrix, int[] array) {
        
        for (int i = array[0]; i <= array[1]; i++) {
            matrix[i] = 0;
        }

        int[] temp = new int[matrix.length - (array[1] - array[0] + 1)];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != 0) {
                temp[index] = matrix[i];
                index++;
            }
        }

        return temp;
        
    }


}
