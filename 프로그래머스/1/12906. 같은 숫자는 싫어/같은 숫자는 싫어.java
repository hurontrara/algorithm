import java.util.*;

public class Solution {
    
    
    List<Integer> answer = new ArrayList<>();
    
    int state = -1;
    
    public List<Integer> solution(int []arr) {
        
        for (int value : arr) {
            
            if (state == value) {
                continue;
            } 
            
            state = value;
            answer.add(value);
            
            
        }
        
        return answer;

    }
    
    
}