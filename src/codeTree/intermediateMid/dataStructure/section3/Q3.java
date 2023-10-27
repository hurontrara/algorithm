package codeTree.intermediateMid.dataStructure.section3;

import java.util.HashSet;
import java.util.Scanner;

public class Q3 {

    static int size;

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            hashSet.add(sc.nextInt());
        }

        System.out.println(hashSet.size());
    }


}
