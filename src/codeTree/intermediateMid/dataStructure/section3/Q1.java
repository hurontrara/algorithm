package codeTree.intermediateMid.dataStructure.section3;

import java.util.HashSet;
import java.util.Scanner;

public class Q1 {

    static int size;

    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            String string = sc.next();
            int value = sc.nextInt();

            switch (string) {

                case "add":
                    hashSet.add(value);
                    break;

                case "remove":
                    hashSet.remove(value);
                    break;

                case "find":
                    System.out.println(hashSet.contains(value));

            }

        }


    }


}
