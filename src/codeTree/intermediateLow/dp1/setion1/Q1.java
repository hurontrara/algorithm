package codeTree.intermediateLow.dp1.setion1;

import java.util.Scanner;

public class Q1 {

    static int num;
    static int[] memo;

    // 재귀로 푸는 방법
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        memo = new int[num + 1];
        memo[0] = 1;
        memo[1] = 1;

        System.out.println(fibo(num));

    }

    private static int fibo(int num) {

        if (memo[num - 1] != 0) {
            return memo[num - 1];
        }

        memo[num - 1] = fibo(num - 1) + fibo(num - 2);
        return memo[num - 1];



    }


}
