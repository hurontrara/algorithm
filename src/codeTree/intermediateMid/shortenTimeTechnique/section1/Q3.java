package codeTree.intermediateMid.shortenTimeTechnique.section1;

import java.util.Scanner;

public class Q3 {

    static Scanner sc = new Scanner(System.in);

    static int n = sc.nextInt();
    static int k = sc.nextInt();
    static int[] arr = new int[n + 1];

    public static void main(String[] args) {
        setting();

        int count = 0;
        for (int i = 1; i < n + 1; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == k)
                    count++;
            }

        }
        System.out.println(count);

    }

    private static void setting() {

        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt() + arr[i - 1];
        }



    }


}
