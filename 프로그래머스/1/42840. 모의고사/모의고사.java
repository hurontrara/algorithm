import java.util.*;

class Solution {
        
    static int[] a = {1, 2, 3, 4, 5}; // 5
    static int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
    static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
    
    static int aV, bV, cV = 0;

    public List<Integer> solution(int[] answers) {
        
        for (int i = 0; i < answers.length; i++) {
            
            if (a[i % 5] == answers[i])
                aV++;
            
            if (b[i % 8] == answers[i])
                bV++;
            
            if (c[i % 10] == answers[i])
                cV++;
            
            
        }
        
        List<Integer> answerArray = new ArrayList<>();
        
        if (aV > bV && aV > cV)
            answerArray.add(1);
        else if (bV > aV && bV > cV)
            answerArray.add(2);
        else if (cV > aV && cV > bV)
            answerArray.add(3);
        
        else if (bV == aV && bV > cV) {
            answerArray.add(1);
            answerArray.add(2);

        }

        else if (bV > aV && bV == cV) {
                        answerArray.add(2);
            answerArray.add(3);

        }

        else if (bV < aV && aV == cV) {
                        answerArray.add(1);
            answerArray.add(3);

        }
        else {
                        answerArray.add(1);
            answerArray.add(2);
            answerArray.add(3);

        }



        
        return answerArray;
        
    }
}