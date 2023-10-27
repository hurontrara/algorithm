import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            return this.y - o.y;
        }


    }



    public static void main(String[] args) {

        TreeSet<Point> treeSet = new TreeSet<>();
        PriorityQueue<Point> queue = new PriorityQueue<>();
        HashSet<Point> hashSet = new HashSet<>();

        treeSet.add(new Point(1, 1));
        treeSet.add(new Point(2, 1));
        queue.add(new Point(2, 2));
        queue.add(new Point(1, 2));
        hashSet.add(new Point(1, 2));
        hashSet.add(new Point(1, 2));


        System.out.println(treeSet.size());
        System.out.println(queue.size());
        System.out.println(hashSet.size());

    }

}

