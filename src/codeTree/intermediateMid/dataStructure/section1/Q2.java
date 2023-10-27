package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q2 {

    static int size;
    static int objectNum;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        objectNum = sc.nextInt();

        for (int i = 0; i < size; i++) {

            int objectInt = sc.nextInt();

            hashMap.put(objectInt, hashMap.getOrDefault(objectInt, 0) + 1);

        }

        for (int i = 0; i < objectNum; i++) {

            int objectInt = sc.nextInt();

            System.out.print(hashMap.getOrDefault(objectInt, 0) + " ");

        }


    }

}
