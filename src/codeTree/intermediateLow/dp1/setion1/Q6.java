package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q6 {

    static int n;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[1000];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 3;


        System.out.println(dp(n));
    }

    private static int dp(int n) {

        if (n <= 2 || memo[n] != 0) {
            return memo[n];
        }

        memo[n] = (dp(n - 1) + dp(n - 2) * 2) % 10007;
        return memo[n];

    }


}
