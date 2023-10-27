package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Q1 {

    static int size;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            String order = sc.next();

            switch (order) {

                case "add":
                    hashMap.put(sc.nextInt(), sc.nextInt());
                    break;

                case "find":
                    Integer value = hashMap.getOrDefault(sc.nextInt(), null);
                    if (value == null)
                        System.out.println("None");
                    else
                        System.out.println(value);

                    break;

                case "remove":
                    hashMap.remove(sc.nextInt());

                    break;

            }


        }

    }


}
