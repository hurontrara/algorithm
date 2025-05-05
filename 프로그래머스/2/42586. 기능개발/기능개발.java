import java.util.*;

class Solution {
    
    List<Integer> tList = new ArrayList<>();
    
    List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        for (int i = 0; i < speeds.length; i++) {
            
            int work = 100 - progresses[i];
            
            int day = 0;
            if (work % speeds[i] == 0) {
                
                day = work / speeds[i];
                
            } else {
                
                day = (work / speeds[i]) + 1;
                
            }
            
            tList.add(day);
            
        }
        
        int present = -1;
        
        for (int value : tList) {
            
            if (value > present) {
                
                answer.add(1);
                present = value;
                
            } else {
                
                answer.set(answer.size() - 1, answer.get(answer.size() - 1) + 1);
                
            }
            
        }
        
        
        return answer;
    }
    
    
    
}