package codeTree.intermediateMid.dataStructure.section4;

import java.util.Scanner;
import java.util.TreeSet;

public class Q2 {

    static int size;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            int m = sc.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int j = 0; j < m; j++) {

                String string = sc.next();
                int value = sc.nextInt();

                switch (string) {

                    case "I":
                        treeSet.add(value);
                        break;

                    case "D":
                        if (treeSet.size() == 0)
                            break;

                        if (value == 1)
                            treeSet.remove(treeSet.last());
                        else
                            treeSet.remove(treeSet.first());

                }

            }

            if (treeSet.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(treeSet.last() + " " + treeSet.first());

        }
    }


}
