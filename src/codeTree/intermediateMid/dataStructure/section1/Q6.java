package codeTree.intermediateMid.dataStructure.section1;

import java.util.HashMap;
import java.util.Scanner;

public class Q6 {

    static int n;
    static int k;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static double count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int intKey = sc.nextInt();

            int intValue = hashMap.getOrDefault(intKey, 0) + 1;

            hashMap.put(intKey, intValue);
        }

        Object[] keyToArray = hashMap.keySet().toArray();

        if (k % 3 == 0)
            count += threeCombination(hashMap.getOrDefault(k / 3, 0));

        for (int i = 0; i < keyToArray.length; i++) {
            for (int j = i + 1; j < keyToArray.length; j++) {

                // 두 개는 다른게 보장
                int firstValue = (int) keyToArray[i];
                int secondValue = (int) keyToArray[j];

                int thirdNeedValue = k - firstValue - secondValue;

                if (thirdNeedValue == firstValue) {
                    count += (double) twoCombination(hashMap.get(firstValue)) * hashMap.get(secondValue);
                    continue;
                }

                if (thirdNeedValue == secondValue) {
                    count += (double) twoCombination(hashMap.get(secondValue)) * hashMap.get(firstValue);
                    continue;
                }

                double doubleValue = (double) hashMap.get(firstValue) * hashMap.get(secondValue) * hashMap.getOrDefault(thirdNeedValue, 0);
                count += doubleValue / 3;


            }
        }

        System.out.println((int) Math.round(count));



    }

    private static int twoCombination(int value) {
        return value * (value - 1) / 2;
    }

    private static int threeCombination(int value) {
        return value * (value - 1) * (value - 2) / 6;
    }


}
