package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q2 {

    static int num;

    static int[] memo = new int[1000];

    public static void main(String[] args) {
        setting();

        int dpResult = dp(num);

        System.out.println(dpResult);
    }

    private static int dp(int num) {

        if (num <= 3) {
            return memo[num - 1];
        }

        if (memo[num - 1] != 0) {
            return memo[num - 1];
        }

        memo[num - 1] = (dp(num - 3) + dp(num - 2)) % 10007;
        return memo[num - 1];

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;


    }
}
