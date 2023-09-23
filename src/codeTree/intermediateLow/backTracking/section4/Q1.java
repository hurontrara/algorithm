package codeTree.intermediateLow.backTracking.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    static int size;
    static int[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        visited = new int[size];

        backTracking(0);
    }

    private static void backTracking(int index) {

        if (index == size) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

            return;
        }


        for (int i = 1; i <= size; i++) {

            if (visited[i - 1] == 1) {
                continue;
            }

            list.add(i);
            visited[i - 1] = 1;

            backTracking(index + 1);

            list.remove(list.size() - 1);
            visited[i - 1] = 0;


        }
    }

}
