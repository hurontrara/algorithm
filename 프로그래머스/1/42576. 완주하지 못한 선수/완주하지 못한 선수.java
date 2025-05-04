import java.util.*;

class Solution {
    
    HashMap<String, Integer> hashMap = new HashMap<>();
    
    
    public String solution(String[] participant, String[] completion) {
        
        for (String human : participant) {
            
            hashMap.put(human, hashMap.getOrDefault(human, 0) + 1);
            
        }
        
        for (String human : completion) {
            
            
            hashMap.put(human, hashMap.get(human) - 1);
            
        }
        
        for (String human : hashMap.keySet()) {
            
            if (hashMap.get(human) == 1)
                return human;
            
        }
        
        return null;
        
        
    }
    
    
    
}