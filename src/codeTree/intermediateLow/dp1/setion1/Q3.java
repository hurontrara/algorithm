package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q3 {

    static int n;

    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        memo = new int[1000];
        memo[0] = 1;
        memo[1] = 2;

        int dpResult = dp(n);

        System.out.println(dpResult);


    }

    private static int dp(int n) {

        if (n <= 1 || memo[n - 1] != 0) {
            return memo[n - 1];
        }

        memo[n - 1] = (dp(n - 2) + dp(n - 1)) % 10007;
        return memo[n - 1];



    }
}
