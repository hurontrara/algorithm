package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q4 {

    static int n;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[1000];
        memo[0] = 1;
        memo[1] = 2;

        System.out.println(dp(n));


    }

    private static int dp(int n) {
        if (n <= 1 || memo[n] != 0) {
            return memo[n];
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (dp(i) * 2) % 1000000007;
            count %= 1000000007;
        }
        count += memo[n - 2] % 1000000007;
        memo[n] = (int) count % 1000000007;

        return memo[n];




    }


}
