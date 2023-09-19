package codeTree.intermediateLow.simulation.gridMoves;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    public static int size, moveNum;
    public static List<List<List<Integer>>> matrix = new ArrayList<>();
    public static int[] moveArray;

    public static int fromRow;
    public static int fromCol;
    public static int fromIndex;

    public static int toRow;
    public static int toCol;
    public static int toIndex;

    public static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    public static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};

    public static void main(String[] args) {
        settings();

        for (int i : moveArray) {

            findFromPosition(i);

            if (findToPosition()) {
                change();
            }




        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                List<Integer> localList = matrix.get(row).get(col);
                if (localList.size() == 0) {
                    System.out.println("None");
                    continue;
                }

                for (Integer integer : localList) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
        }



    }

    private static void change() {

        List<Integer> fromList = matrix.get(fromRow).get(fromCol);
        List<Integer> fromSubList = fromList.subList(0, fromIndex + 1);
        List<Integer> fromSubListCopy = new ArrayList<>(fromSubList);
        fromSubList.clear();

        List<Integer> toList = matrix.get(toRow).get(toCol);
        toList.addAll(0, fromSubListCopy);

    }

    private static boolean findToPosition() {

        int maxvalue = -1;
        for (int dir = 0; dir < 8; dir++) {

            int postRow = fromRow + dx[dir];
            int postCol = fromCol + dy[dir];

            if (existCheck(postRow, postCol)) {
                List<Integer> localList = matrix.get(postRow).get(postCol);
                for (int i = 0; i < localList.size(); i++) {
                    if (localList.get(i) > maxvalue) {
                        toRow = postRow;
                        toCol = postCol;
                        toIndex = i;
                        maxvalue = localList.get(i);
                    }
                }

            }


        }


        if (maxvalue == -1) {
            return false;
        }

        return true;



    }

    private static boolean existCheck(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    private static void findFromPosition(int i) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                List<Integer> list = matrix.get(row).get(col);
                for (int index = 0; index < list.size(); index++) {
                    if (list.get(index).equals(i)) {
                        fromRow = row;
                        fromCol = col;
                        fromIndex = index;
                    }
                }


            }
        }




    }

    private static void settings() {

        Scanner sc = new Scanner(System.in);
        size = sc.nextInt(); moveNum = sc.nextInt();  moveArray = new int[moveNum];
        for (int row = 0; row < size; row++) {
            List<List<Integer>> yDimension = new ArrayList<>();
            for (int col = 0; col < size; col++) {
                List<Integer> zDimension = new ArrayList<>();
                zDimension.add(sc.nextInt());
                yDimension.add(zDimension);
            }
            matrix.add(yDimension);
        }


        for (int i = 0; i < moveArray.length; i++) {
            moveArray[i] = sc.nextInt();
        }


    }

}
