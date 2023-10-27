package codeTree.intermediateMid.dataStructure.section2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q4 {

    static int size;

    static TreeMap<String, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            String key = sc.next();
            int value = treeMap.getOrDefault(key, 0) + 1;

            treeMap.put(key, value);

        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }


}
