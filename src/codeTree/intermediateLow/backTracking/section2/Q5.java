package codeTree.intermediateLow.backTracking.section2;

import java.util.Scanner;

public class Q5 {

    static int size;
    static int[] matrix;

    static int minJump = -1;


    public static void main(String[] args) {
        setting();

        backTracking(0, 0);

        System.out.println(minJump);
    }

    private static void backTracking(int index, int count) {

        if (index >= size) {
            return;
        }

        if (index == size - 1) {

            if (minJump == -1) {
                minJump = count;
            } else if (count < minJump) {
                minJump = count;
            }

        }

        int value = matrix[index];
        for (int i = 1; i <= value; i++) {
            backTracking(index + i, count + 1);
        }


    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        matrix = new int[size];
        for (int i = 0; i < size; i++) {
            matrix[i] = sc.nextInt();
        }

    }
}
