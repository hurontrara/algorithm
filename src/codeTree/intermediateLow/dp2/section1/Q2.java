package codeTree.intermediateLow.dp2.section1;

import java.util.List;
import java.util.Scanner;

public class Q2 {

    static int size;
    static int sectionNum;
    static int[] numList;

    public static void main(String[] args) {
        setting();
    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        sectionNum = sc.nextInt();

        for (int i = 0; i < size; i++) {
            numList[i] = sc.nextInt();
        }

    }


}
