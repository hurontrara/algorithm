package codeTree.intermediateLow.simulation.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    public static int size;
    public static int price;
    public static int[][] matrix;
    public static int maxK;
    public static int maxGoldNum = 0;

    // 우리 목표는 손해를 보지 않고 캘 수 있는 최대 금의 개수를 구하는 것
    // 결국 모든 경우의 수를 구해봐야 함
    // 그러나, k가 maxK보다 커지면, cost만 커지므로 의미가 없음
    public static void main(String[] args) {

        // 인풋 받기
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        price = sc.nextInt();
        matrix = new int[size][size];
        maxK = 2 * (size - 1);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }


        // 모든 격자에 대하여 로직 적용
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                miningLogic(row, col);
            }
        }

        System.out.println(maxGoldNum);
    }

    private static void miningLogic(int row, int col) {
        // 모든 격자에 대하여, 점과의 거리가 k 이하이면 리스트에 추가(진짜 개완전탐색)
        // 비용은 공식, 수익은 리스트의 합

        for (int k = 0; k <= maxK; k++) {
            List<Integer> localList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (Math.abs(row - i) + Math.abs(col - j) <= k) {
                        localList.add(matrix[i][j]);

                    }
                }
            }

            int localGoldNum = localList.stream().mapToInt(Integer::intValue).sum();
            int profit = localGoldNum * price;
            int cost = k * k + (k + 1) * (k + 1);

            if (profit >= cost) {
                maxGoldNum = Math.max(localGoldNum, maxGoldNum);
            }


        }


    }


}
