package codeTree.intermediateMid.dataStructure.section2;

import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

public class Q1 {

    static int size;

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            String string = sc.next();

            switch (string) {
                case "add":
                    int key = sc.nextInt();
                    int value = sc.nextInt();
                    treeMap.put(key, value);
                    break;

                case "find":
                    Integer findValue = treeMap.getOrDefault(sc.nextInt(), null);
                    if (findValue == null)
                        System.out.println("None");
                    else
                        System.out.println(findValue);
                    break;

                case "remove":
                    treeMap.remove(sc.nextInt());
                    break;

                case "print_list":
                    if (treeMap.isEmpty())
                        System.out.println("None");
                    else
                        for (Integer integer : treeMap.values()) {
                            System.out.print(integer + " ");
                        }
                        System.out.println();

            }

        }


    }


}
