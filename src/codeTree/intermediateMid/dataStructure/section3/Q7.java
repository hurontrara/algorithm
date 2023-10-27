package codeTree.intermediateMid.dataStructure.section3;

import java.util.*;

public class Q7 {

    static int n, g;

    static int[] groupHumanNum;
    static int[] groupCount;

    static List<List<Integer>> group = new ArrayList<>();

    static HashMap<Integer, List<Integer>> humanGroupHashMap = new HashMap<>();

    static Queue<Integer> humanQueue = new LinkedList<>();
    static HashSet<Integer> invited = new HashSet<>();

    public static void main(String[] args) {
        setting();

        initialSetting();

        queueProcess();

        System.out.println(invited.size());
    }

    private static void queueProcess() {

        while (!humanQueue.isEmpty()) {

            Integer human = humanQueue.poll();
            List<Integer> humanGroupList = humanGroupHashMap.get(human);
            for (Integer humanGroup : humanGroupList) {
                groupCount[humanGroup] += 1;

                if (groupCount[humanGroup] + 1 == groupHumanNum[humanGroup]) {
                    List<Integer> localGroup = group.get(humanGroup);
                    for (Integer groupMember : localGroup) {

                        if (invited.contains(groupMember)) {
                            continue;
                        }

                        invited.add(groupMember);
                        humanQueue.add(groupMember);

                    }

                }

            }

        }

    }

    private static void initialSetting() {

        for (List<Integer> groupPeople : group) {

            if (groupPeople.size() == 1) {
                int human = groupPeople.get(0);
                humanQueue.add(human);
                invited.add(human);
            }

        }


        if (!humanQueue.contains(1))
            humanQueue.add(1);
        invited.add(1);

    }

    private static void setting() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        g = sc.nextInt();

        groupHumanNum = new int[g + 1];
        groupCount = new int[g + 1];
        for (int i = 0; i <= g; i++) {
            group.add(new ArrayList<>());
        }

        for (int i = 1; i <= g; i++) {

            int localGroupHumanNum = sc.nextInt();
            groupHumanNum[i] = localGroupHumanNum;

            for (int j = 0; j < localGroupHumanNum; j++) {

                int key = sc.nextInt();
                List<Integer> value = humanGroupHashMap.getOrDefault(key, new ArrayList<>());
                value.add(i);
                humanGroupHashMap.put(key, value);
                group.get(i).add(key);
            }

        }

    }


}
