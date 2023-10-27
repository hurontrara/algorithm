package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q1 {

    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            String string = sc.next();

            switch (string) {

                case "add":
                    treeSet.add(sc.nextInt());
                    break;

                case "largest":
                    if (treeSet.isEmpty()) {
                        System.out.println("None");
                    }
                    else {
                        System.out.println(treeSet.last());
                    }
                    break;

                case "smallest":
                    if (treeSet.isEmpty()) {
                        System.out.println("None");
                    }
                    else {
                        System.out.println(treeSet.first());
                    }
                    break;

                case "find":
                    System.out.println(treeSet.contains(sc.nextInt()));
                    break;

                case "lower_bound":
                    Integer value = treeSet.ceiling(sc.nextInt());
                    if (value != null)
                        System.out.println(value);
                    else
                        System.out.println("None");
                    break;

                case "upper_bound":
                    Integer value2 = treeSet.higher(sc.nextInt());
                    if (value2 != null)
                        System.out.println(value2);
                    else
                        System.out.println("None");
                    break;

                case "remove":
                    treeSet.remove(sc.nextInt());
            }
        }


    }


}
