package codeTree.intermediateMid.dataStructure.section1;


import java.util.*;

public class Q9 {

    static int size;
    static HashMap<HashMap<String, Integer>, Integer> hashMapList = new HashMap<>();

    public static void main(String[] args) {
        setting();

        System.out.println(Collections.max(hashMapList.values()));


    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            String string = sc.next();
            String[] stringSplit = string.split("");

            HashMap<String, Integer> localHashmap = new HashMap<>();
            for (String s : stringSplit) {
                int value = localHashmap.getOrDefault(s, 0) + 1;
                localHashmap.put(s, value);
            }

            boolean changed = false;
            for (Map.Entry<HashMap<String, Integer>, Integer> hashMapListEntry : hashMapList.entrySet()) {
                HashMap<String, Integer> key = hashMapListEntry.getKey();
                Integer value = hashMapListEntry.getValue();

                if (key.equals(localHashmap)) {
                    hashMapList.put(key, value + 1);
                    changed = true;
                    break;
                }
            }

            if (!changed) {
                hashMapList.put(localHashmap, 1);
            }


        }


    }


}