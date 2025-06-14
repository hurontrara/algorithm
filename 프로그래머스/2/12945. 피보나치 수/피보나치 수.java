import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    public int solution(int n) {
        
        list.add(0); list.add(1);
        
        for (int i = 2; i <= n; i++) {
            
            int a = list.get(list.size() - 2);
            int b = list.get(list.size() - 1);
            list.add((a + b) % 1234567);
            
        }
        
        return list.get(list.size() - 1);
        
        
    }
}