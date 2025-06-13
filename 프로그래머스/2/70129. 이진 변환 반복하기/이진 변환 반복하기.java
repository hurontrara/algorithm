import java.util.*;

class Solution {

    int cnt = 0;
    int[] answerArray = new int[2];

    public int[] solution(String s) {

        int count = 0;
        String tmpString = s;

        while (!tmpString.equals("1")) {
            count++;

            tmpString = zeroCut(tmpString);

            tmpString = Integer.toBinaryString(tmpString.length());
        }

        answerArray[0] = count;
        answerArray[1] = cnt;
        return answerArray;
    }

    String zeroCut(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            } else {
                sb.append('1');
            }
        }

        return sb.toString();
    }
}
