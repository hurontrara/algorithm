import java.util.*;

class Solution {
    
    int value = 0;
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(int n) {
        
        makeListAndMakeSet(n);
        
        for (int value : set) {
            
            if (value < n)
                continue;
            
            if (set.contains(value - n)) {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    void makeListAndMakeSet(int n) {
        
        for (int i = 0; i <= 10000; i++) {
            
            value += i;
            set.add(value); 
            
            if (i > n) {
                return;
            }
            
        }
        
    }
    
    
}