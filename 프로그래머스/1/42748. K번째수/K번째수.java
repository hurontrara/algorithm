import java.util.*;


class Solution {
    
    List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(int[] array, int[][] commands) {
        
        for (int[] command : commands) {
            
            int a = command[0] - 1; int b = command[1] - 1; int c = command[2] - 1;
            
            List<Integer> tmpList = new ArrayList<>();
            
            for (int i = a; i <= b; i++) {
                
                tmpList.add(array[i]);
                
            }
            
            Collections.sort(tmpList);
            
            answer.add(tmpList.get(c));
            
        }
        
        return answer;
        
        
    }
}