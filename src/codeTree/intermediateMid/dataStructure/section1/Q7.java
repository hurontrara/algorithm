package codeTree.intermediateMid.dataStructure.section1;

import java.util.*;

public class Q7 {

    static class Point {

        int num;
        int count;

        Point(int num, int count) {
            this.num = num;
            this.count = count;
        }

    }

    static int n;
    static int k;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) {
        setting();

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            pointList.add(new Point(key, value));
        }

        pointList.sort((point1, point2) -> {

            if (point1.count == point2.count) {
                return point2.num - point1.num;
            }

            return point2.count - point1.count;
        });

        for (int i = 0; i < k; i++) {
            Point point = pointList.get(i);
            System.out.print(point.num + " ");
        }



    }

    private static void setting() {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int key = sc.nextInt();
            int value = hashMap.getOrDefault(key, 0) + 1;

            hashMap.put(key, value);

        }
    }

}
