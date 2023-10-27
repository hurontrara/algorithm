package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q11 {

    static int size;
    static long sumValue = 0;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();

            if (hashMap.containsKey(key)) {
                hashMap.put(key, Math.min(hashMap.get(key), value));
                continue;
            }

            hashMap.put(key, value);

        }

        for (Integer value : hashMap.values()) {
            sumValue += value;
        }
        System.out.println(sumValue);


    }

}
