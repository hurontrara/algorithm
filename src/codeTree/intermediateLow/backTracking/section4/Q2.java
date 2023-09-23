package codeTree.intermediateLow.backTracking.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    static int size;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        visited = new boolean[size];

        backTracking(size - 1);

    }

    private static void backTracking(int index) {

        if (index == -1) {

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

        }

        for (int i = size; i > 0; i--) {

            if (visited[i - 1]) {
                continue;
            }

            visited[i - 1] = true;
            list.add(i);

            backTracking(index - 1);

            list.remove(list.size() - 1);
            visited[i - 1] = false;




        }


    }


}
