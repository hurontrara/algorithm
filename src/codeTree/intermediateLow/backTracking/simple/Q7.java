package codeTree.intermediateLow.backTracking.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q7 {

    static String form;
    static int numLength;

    static List<Integer> numlist = new ArrayList<>();
    static List<String> labelList = new ArrayList<>();

    static HashMap<String, Integer> mappingMap = new HashMap<>();
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        setting();

        backTracking(0);

        System.out.println(maxValue);


    }

    private static void backTracking(int index) {

        if (index == numLength) {

            int localNum = numlist.get(0);
            for (int i = 0; i < labelList.size(); i++) {
                String label = labelList.get(i);
                Integer num = numlist.get(i + 1);

                switch (label) {
                    case "+":
                        localNum += num;
                        break;
                    case "-":
                        localNum -= num;
                        break;
                    case "*":
                        localNum *= num;
                }

            }
            if (localNum > maxValue) {
                maxValue = localNum;
            }

            if (localNum == 16) {
                return;
            }

            return;

        }


        String localAlphabet = String.valueOf(form.charAt(index * 2));
        if (mappingMap.get(localAlphabet) != null) {
            numlist.add(mappingMap.get(localAlphabet));

            backTracking(index + 1);

            numlist.remove(numlist.size() - 1);

            return;
        }

        for (int num = 1; num <= 4; num++) {

            mappingMap.put(localAlphabet, num);

            numlist.add(num);

            backTracking(index + 1);

            numlist.remove(numlist.size() - 1);

            mappingMap.remove(localAlphabet);


        }


    }


    private static void setting() {
        Scanner sc = new Scanner(System.in);
        form = sc.next();

        numLength = (form.length() + 1) / 2;

        for (int i = 1; i < form.length(); i += 2) {
            String label = String.valueOf(form.charAt(i));
            labelList.add(label);
        }
    }


}
