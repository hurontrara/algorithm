package codeTree.intermediateMid.dataStructure.section3;

import java.util.HashSet;
import java.util.Scanner;

public class Q8 {

    static int n, m;

    static HashSet<Integer> firstSet = new HashSet<>();
    static HashSet<Integer> lastSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            firstSet.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            lastSet.add(sc.nextInt());
        }

        // 교집합
        int cnt = 0;
        if (firstSet.size() > lastSet.size())
            for (Integer element : lastSet) {
                if (firstSet.contains(element))
                    cnt += 1;
            }

        else
            for (Integer element : firstSet) {
                if (lastSet.contains(element))
                    cnt += 1;
            }


        System.out.println(n + m - 2 * cnt);


    }


}
