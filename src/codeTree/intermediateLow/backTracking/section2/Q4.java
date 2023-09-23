package codeTree.intermediateLow.backTracking.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    static int n;

    static String minValue = null;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list.add(4);

        backTracking(1);

        System.out.println(minValue);

    }

    private static void backTracking(int index) { // 인덱스 4인 경우에 0~1 / 2~3 체크

        int nonSameCount = 0;
        for (int i = 1; i <= index / 2; i++) {

            for (int j = index - i * 2; j < index - i; j++) {

                int startIndex = j;
                int endIndex = j + i;

                if (!list.get(startIndex).equals(list.get(endIndex))) {
                    nonSameCount++;
                    break;
                }
            }

            if (nonSameCount != i) {
                return;
            }


        }



        if (index == n) {
            StringBuilder numString = new StringBuilder();

            for (Integer integer : list) {
                numString.append(integer.toString());
            }

            String value = numString.toString();

            System.out.println(value);

            System.exit(0);

        }


        for (int i = 4; i <= 6; i++) {

            list.add(i);

            backTracking(index + 1);

            list.remove(list.size() - 1);
        }



    }


}
