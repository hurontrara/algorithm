package codeTree.intermediateMid.dataStructure.section3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Q5 {

    static class Human {

        HashSet<Integer> hashSet = new HashSet<>();
        Human(int firstSeat) {
            this.hashSet.add(firstSeat);
        }

    }

    static Scanner sc = new Scanner(System.in);

    static int size, changeNum;

    static int[] changeLeft;
    static int[] changeRight;

    static int[] humanArray;
    static List<Human> humanList = new ArrayList<>();


    public static void main(String[] args) {
        setting();

        for (int count = 0; count < 3; count++) {

                for (int i = 0; i < changeNum; i++) {

                    int firstIndex = changeLeft[i];
                    int lastIndex = changeRight[i];

                    int firstValue = humanArray[firstIndex];
                    int lastValue = humanArray[lastIndex];

                    humanList.get(firstValue).hashSet.add(lastIndex);
                    humanList.get(lastValue).hashSet.add(firstIndex);

                    humanArray[lastIndex] = firstValue;
                    humanArray[firstIndex] = lastValue;
                }

        }

        for (Human human : humanList) {
            System.out.println(human.hashSet.size());
        }

    }

    private static void setting() {

        size = sc.nextInt(); changeNum = sc.nextInt();

        humanArray = new int[size];
        for (int i = 0; i < size; i++) {
            humanArray[i] = i;
            humanList.add(new Human(i));
        }

        changeLeft = new int[changeNum];
        changeRight = new int[changeNum];
        for (int i = 0; i < changeNum; i++) {
            changeLeft[i] = sc.nextInt() - 1;
            changeRight[i] = sc.nextInt() - 1;
        }

    }



}
