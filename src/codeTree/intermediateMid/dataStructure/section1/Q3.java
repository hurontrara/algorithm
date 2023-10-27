package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {

    static int count;

    static HashMap<String, Integer> hashMap = new HashMap<>();

    static int maxNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        for (int i = 0; i < count; i++) {

            String string = sc.next();

            int newCount = hashMap.getOrDefault(string, 0) + 1;

            maxNum = Math.max(maxNum, newCount);

            hashMap.put(string, newCount);

        }

        System.out.println(maxNum);


    }


}
