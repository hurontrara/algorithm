package codeTree.intermediateMid.dataStructure.section2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q3 {

    static int size;

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            int key = sc.nextInt();

            if (treeMap.containsKey(key))
                continue;
            else
                treeMap.put(key, i + 1);

        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


}
