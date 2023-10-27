package codeTree.intermediateMid.shortenTimeTechnique.section1;

import java.util.Collections;
import java.util.Scanner;

public class Q1 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int k = sc.nextInt();

    static int[] arr = new int[n];
    static int[] sumArr = new int[n];

    public static void main(String[] args) {
        setting();

        for (int i = k; i < n; i++) {

            int saveValue = sumArr[i - 1];

            int minusValue = arr[i - k];

            int plusValue = arr[i];

            sumArr[i] = saveValue - minusValue + plusValue;

        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, sumArr[i]);
        }
        System.out.println(maxValue);


    }

    private static void setting() {

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int initialValue = 0;
        for (int i = 0; i < k; i++) {
            initialValue += arr[i];
        }
        sumArr[k - 1] = initialValue;


    }


}
