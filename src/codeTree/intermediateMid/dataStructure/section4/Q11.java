package codeTree.intermediateMid.dataStructure.section4;


import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Q11 {

    static class Problem implements Comparable<Problem> {

        int num;
        int rating;

        Problem(int num, int rating) {
            this.num = num;
            this.rating = rating;
        }

        public int compareTo(Problem problem) {

            if (this.rating == problem.rating)
                return this.num - problem.num;
            else
                return this.rating - problem.rating;

        }


    }


    static Scanner sc = new Scanner(System.in);

    static int n, m;

    static TreeSet<Problem> problemTreeSet = new TreeSet<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();



    public static void main(String[] args) {
        setting();

        for (int i = 0; i < m; i++) {
            process();
        }
    }

    private static void process() {

        String string = sc.next();

        switch (string) {

            case "ad":

                int addNum = sc.nextInt();
                int addRating = sc.nextInt();

                if (hashMap.containsKey(addNum)) {
                    int containRating = hashMap.get(addNum);
                    hashMap.remove(addNum);
                    problemTreeSet.remove(new Problem(addNum, containRating));
                }

                problemTreeSet.add(new Problem(addNum, addRating));
                hashMap.put(addNum, addRating);

                break;

            case "sv":

                int svNum = sc.nextInt();
                int svRating = sc.nextInt();

                problemTreeSet.remove(new Problem(svNum, svRating));
                hashMap.remove(svNum);

                break;

            case "rc":

                int rcValue = sc.nextInt();

                if (rcValue == 1)
                    System.out.println(problemTreeSet.last().num);
                else
                    System.out.println(problemTreeSet.first().num);


        }

    }

    private static void setting() {

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int rating = sc.nextInt();

            problemTreeSet.add(new Problem(num, rating));

            hashMap.put(num, rating);
        }

        m = sc.nextInt();

    }

}
