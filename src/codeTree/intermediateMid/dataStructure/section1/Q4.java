package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q4 {

    static int n;
    static int m;

    static HashMap<String, Integer> stringToIntegerHashMap = new HashMap<>();
    static HashMap<Integer, String> integerToStringHashMap = new HashMap<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String string = sc.next();

            stringToIntegerHashMap.put(string, i + 1);
            integerToStringHashMap.put(i + 1, string);
        }

        for (int i = 0; i < m; i++) {

            String stringOrInteger = sc.next();

            try {
                int intValue = Integer.parseInt(stringOrInteger);
                System.out.println(integerToStringHashMap.get(intValue));
            } catch (Exception e) {
                String stringValue = String.valueOf(stringOrInteger);
                System.out.println(stringToIntegerHashMap.get(stringValue));
            }

        }



    }


}
