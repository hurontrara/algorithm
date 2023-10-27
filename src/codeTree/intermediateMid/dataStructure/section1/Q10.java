package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q10 {

    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string = sc.next();

        String[] split = string.split("");

        for (String key : split) {
            int value = hashMap.getOrDefault(key, 0) + 1;
            hashMap.put(key, value);
        }

        for (String s : split) {
            Integer value = hashMap.get(s);

            if (value.equals(1)) {
                System.out.println(s);
                System.exit(0);
            }
        }

        System.out.println("None");

    }


}
