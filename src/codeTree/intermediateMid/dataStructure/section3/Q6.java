package codeTree.intermediateMid.dataStructure.section3;

import java.util.HashSet;
import java.util.Scanner;

public class Q6 {

    static int n, m;

    static String[][] aMatrix;
    static String[][] bMatrix;

    static int count = 0;

    public static void main(String[] args) {
        setting();

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {

                    canCheck(i, j, k);


                }
            }
        }

        System.out.println(count);
    }

    private static void canCheck(int i, int j, int k) {

        HashSet<String> hashSet = new HashSet<>();

        for (int row = 0; row < n; row++) {
            String localString = aMatrix[row][i] + aMatrix[row][j] + aMatrix[row][k];
            hashSet.add(localString);
        }

        for (int row = 0; row < n; row++) {
            String localString = bMatrix[row][i] + bMatrix[row][j] + bMatrix[row][k];

            if (hashSet.contains(localString))
                return;

        }

        count++;



    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        aMatrix = new String[n][m];
        bMatrix = new String[n][m];

        for (int i = 0; i < n; i++) {

            String string = sc.next();
            String[] split = string.split("");
            for (int j = 0; j < m; j++) {
                aMatrix[i][j] = split[j];
            }

        }

        for (int i = 0; i < n; i++) {

            String string = sc.next();
            String[] split = string.split("");
            for (int j = 0; j < m; j++) {
                bMatrix[i][j] = split[j];
            }

        }



    }


}
