package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q8 {


    static int size;
    static HashMap<Integer, Integer> oneHashMap = new HashMap<>();
    static HashMap<Integer, Integer> twoHashMap = new HashMap<>();
    static HashMap<Integer, Integer> threeHashMap = new HashMap<>();
    static HashMap<Integer, Integer> fourHashMap = new HashMap<>();

    static HashMap<Integer, Integer> someOneHashMap = new HashMap<>();
    static HashMap<Integer, Integer> someTwoHashMap = new HashMap<>();

    static int count = 0;


    public static void main(String[] args) {
        setting();

        someHashMapProcess();

        countProcess();

        System.out.println(count);
        
    }

    private static void countProcess() {

        for (Map.Entry<Integer, Integer> entry : someOneHashMap.entrySet()) {
            
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            Integer opponentValue = someTwoHashMap.getOrDefault(key * -1, 0);

            count += value * opponentValue;

        }
    }

    private static void someHashMapProcess() {
        
        for (Map.Entry<Integer, Integer> oneHashMapEntry : oneHashMap.entrySet()) {
            for (Map.Entry<Integer, Integer> twoHashMapEntry : twoHashMap.entrySet()) {

                int sumKey = oneHashMapEntry.getKey() + twoHashMapEntry.getKey();
                int sumValue = someOneHashMap.getOrDefault(sumKey, 0) + (oneHashMapEntry.getValue() * twoHashMapEntry.getValue());
                someOneHashMap.put(sumKey, sumValue);
                
            }
        }

        for (Map.Entry<Integer, Integer> threeHashMapEntry : threeHashMap.entrySet()) {
            for (Map.Entry<Integer, Integer> fourHashMapEntry : fourHashMap.entrySet()) {

                int sumKey = threeHashMapEntry.getKey() + fourHashMapEntry.getKey();
                int sumValue = someTwoHashMap.getOrDefault(sumKey, 0) + (threeHashMapEntry.getValue() * fourHashMapEntry.getValue());
                someTwoHashMap.put(sumKey, sumValue);
                
            }
        }

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        for (int i = 0; i < size; i++) {

            int key = sc.nextInt();
            int value = oneHashMap.getOrDefault(key, 0) + 1;

            oneHashMap.put(key, value);

        }

        for (int i = 0; i < size; i++) {

            int key = sc.nextInt();
            int value = twoHashMap.getOrDefault(key, 0) + 1;

            twoHashMap.put(key, value);

        }

        for (int i = 0; i < size; i++) {

            int key = sc.nextInt();
            int value = threeHashMap.getOrDefault(key, 0) + 1;

            threeHashMap.put(key, value);

        }

        for (int i = 0; i < size; i++) {

            int key = sc.nextInt();
            int value = fourHashMap.getOrDefault(key, 0) + 1;

            fourHashMap.put(key, value);

        }

    }


}
