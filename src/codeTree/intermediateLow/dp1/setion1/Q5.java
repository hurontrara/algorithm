package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q5 {

    static int n;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[20];
        memo[0] = 1; memo[1] = 1; memo[2] = 2;


        System.out.println(dp(n));
    }

    private static int dp(int n) {

        if (n <= 2 || memo[n] != 0) {
            return memo[n];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += dp(i) * dp(n - 1 - i);
        }
        memo[n] = count;
        return memo[n];

    }


}
