package codeTree.intermediateLow.simulation.pushAndPull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {

    public static String A;
    public static List<String> array;
    public static int length = 100;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        A = sc.next();

        for (int i = 0; i < A.length(); i++) {

            listingProcess();

            rotationProcess();

            countProcess();

        }

        System.out.println(length);



    }

    private static void countProcess() {

        StringBuilder sb = new StringBuilder();

        for (String s : array) {
            sb.append(s);
        }

        String finalString = sb.toString();

        if (finalString.length() < length) {
            length = finalString.length();
        }




    }

    private static void rotationProcess() {

        List<String> localList = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            localList.add(String.valueOf(A.charAt(i)));
        }

        String temp = localList.get(localList.size() - 1);
        for (int i = localList.size() - 1; i > 0; i--) {
            localList.set(i, localList.get(i - 1));
        }
        localList.set(0, temp);

        StringBuilder sb = new StringBuilder();
        for (String s : localList) {
            sb.append(s);
        }

        A = sb.toString();

    }

    private static void listingProcess() {

        String localString = "?";
        array = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            String a = String.valueOf(A.charAt(i));

            if (a.equals(localString)) {
                String num = array.get(array.size() - 1);
                Integer numToInt = Integer.parseInt(num) + 1;
                String intToString = String.valueOf(numToInt);
                array.set(array.size() - 1, intToString);
            } else {
                array.add(a);
                array.add("1");
                localString = a;
            }



        }



    }

}
