package codeTree.intermediateMid.dataStructure.section4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q12 {

    static int n, m;
    static Scanner sc = new Scanner(System.in);

    static TreeMap<Integer, Integer> hashMap = new TreeMap<>();
    static TreeSet<Integer> treeSet = new TreeSet<>();


    public static void main(String[] args) {

        n = sc.nextInt(); m = sc.nextInt();
        hashMap.put(n + 1, 1);

        treeSet.add(-1);
        treeSet.add(n + 1);

        for (int i = 0; i < m; i++) {

            process();
        }

    }

    private static void process() {

        int input = sc.nextInt();

        Integer frontValue = treeSet.lower(input);
        Integer backValue = treeSet.higher(input);
        int size = backValue - frontValue - 1;

        Integer sizeCount = hashMap.get(size);
        if (sizeCount == 1)
            hashMap.remove(size);
        else
            hashMap.put(size, sizeCount - 1);

        treeSet.add(input);
        int leftSize = input - frontValue - 1;
        int rightSize = backValue - input - 1;
        hashMap.put(leftSize, hashMap.getOrDefault(leftSize, 0) + 1);
        hashMap.put(rightSize, hashMap.getOrDefault(rightSize, 0) + 1);

        System.out.println(hashMap.lastKey());


    }

    private static void setting() {

    }


}
