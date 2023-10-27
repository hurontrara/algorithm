package codeTree.intermediateMid.shortenTimeTechnique.section1;

import java.util.Scanner;

public class Q4 {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int k = sc.nextInt();
    static int b = sc.nextInt();

    static int[] arr = new int[n + 1];
    static int[] omit = new int[n + 1];
    static int[] sumArr = new int[n + 1];


    public static void main(String[] args) {
        setting();

        for (int i = k + 1; i <= n; i++) {

            sumArr[i] = sumArr[i - 1] + omit[i] - omit[i - k];

        }

        int minValue = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            minValue = Math.min(minValue, sumArr[i]);
        }
        System.out.println(minValue);


    }

    private static void setting() {

        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < b; i++) {
            omit[sc.nextInt()] = 1;
        }

        int initialValue = 0;
        for (int i = 0; i <= k; i++) {
            if (omit[i] == 1)
                initialValue++;
        }
        sumArr[k] = initialValue;

    }


}
