package codeTree.intermediateMid.dataStructure.section1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Q5 {

    static int size;
    static int targetNum;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        targetNum = sc.nextInt();

        for (int i = 0; i < size; i++) {
            int intKey = sc.nextInt();

            int intValue = hashMap.getOrDefault(intKey, 0) + 1;

            hashMap.put(intKey, intValue);

        }

        HashMap<Integer, Integer> copyMap = new HashMap<>(hashMap);

        for (Integer key : copyMap.keySet()) {

            int pair = targetNum - key;

            if (key == pair) {
                count += combination(hashMap.get(key));
            }

            else {

                int keyValue = hashMap.getOrDefault(key, 0);
                int pairValue = hashMap.getOrDefault(pair, 0);

                count += keyValue * pairValue;

                hashMap.put(key, 0);
                hashMap.put(pair, 0);

            }

        }

        System.out.println(count);


    }


    private static int combination(int num) {
        return num * (num - 1) / 2;
    }


}
