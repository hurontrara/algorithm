import java.util.*;

class Solution {
    
    static int[] answer;
    
    public int[] solution(int[] array, int[][] commands) {
        
        answer = new int[commands.length];
        
        int answerIndex = 0;
        for (int[] command : commands) {
            
            // i = 2 , j = 5 , k = 3
            int i = command[0] - 1; int j = command[1] - 1; int k = command[2] - 1;
            
            int[] localArray = new int[j - i + 1];
            for (int index = i; index <= j; index++) {
                localArray[index - i] = array[index];
            }
            Arrays.sort(localArray);
            
            
            answer[answerIndex++] = localArray[k];
            
            
            
        }
        
        return answer;
        
        
    }
    
    
}


// commands 의 i번째 ~ j번째 했을때 k번째 숫자