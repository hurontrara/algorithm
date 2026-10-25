import java.util.*;


class Solution {
    
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    long answer = 0;
    
    public long solution(int n, int[] works) {
        
        for (int work : works) {
            queue.add(work * -1);
        }
        
        for (int i = 0; i < n; i++) {
            
            if (queue.isEmpty()) {break;}
            
            Integer value = queue.poll();
            if (value == -1) { continue; }
            
            queue.add(value + 1);
            
            
        }
        
        while (!queue.isEmpty()) {
            
            int value = queue.poll();
            answer += value * value;
            
        }
        
        return answer;
        
        
        
    }
    
    
}