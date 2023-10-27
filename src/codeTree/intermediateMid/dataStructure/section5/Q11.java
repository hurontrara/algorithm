package codeTree.intermediateMid.dataStructure.section5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11 {

    static class Waiting implements Comparable<Waiting> {

        int arrive;
        int time;
        int priority;

        Waiting(int arrive, int time, int priority) {
            this.arrive = arrive;
            this.time = time;
            this.priority = priority;
        }

        public int compareTo(Waiting waiting) {

            if (this.arrive == waiting.arrive) {
                return this.priority - waiting.priority;
            }

            return this.arrive - waiting.arrive;

        }

    }

    static class Process implements Comparable<Process> {

        int arrive;
        int time;
        int priority;

        Process(int arrive, int time, int priority) {
            this.arrive = arrive;
            this.time = time;
            this.priority = priority;
        }

        public int compareTo(Process process) {
            return this.priority - process.priority;
        }

    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int t = 0;
    static int maxTime = 0;

    static PriorityQueue<Waiting> waitingQueue = new PriorityQueue<>();
    static PriorityQueue<Process> processingQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        setting();

        process();

        System.out.println(maxTime);

    }

    private static void process() {

        while (true) {

            if (processingQueue.isEmpty()) {
                Waiting waiting = waitingQueue.poll();
                t = waiting.arrive;

                processingQueue.add(new Process(waiting.arrive, waiting.time, waiting.priority));
            }

            Process poll = processingQueue.poll();
            maxTime = Math.max(t - poll.arrive, maxTime);

            t += poll.time;

            while (waitingQueue.size() != 0 && waitingQueue.peek().arrive <= t) {
                Waiting pollWaiting = waitingQueue.poll();

                processingQueue.add(new Process(pollWaiting.arrive, pollWaiting.time, pollWaiting.priority));
            }

            if (waitingQueue.size() == 0 && processingQueue.size() == 0) {
                break;
            }

        }

    }

    private static void setting() {

        for (int i = 0; i < n; i++) {
            waitingQueue.add(new Waiting(sc.nextInt(), sc.nextInt(), i));
        }

    }


}
