package codeTree.intermediateMid.dataStructure.section2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q2 {

    static int size;

    static TreeMap<String, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        setting();

        printProcess();
    }

    private static void printProcess() {

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            double value = (double) entry.getValue() * 100 / size;

            System.out.println(key + " " + String.format("%.4f", value));
        }


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            String key = sc.next();
            Integer value = treeMap.getOrDefault(key, 0) + 1;
            treeMap.put(key, value);
        }

    }


}
