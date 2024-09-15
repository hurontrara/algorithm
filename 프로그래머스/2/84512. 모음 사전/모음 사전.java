import java.util.*;

class Solution {
    
    static HashMap<String, Integer> hashMap = new HashMap<>();
    
    static List<Integer> tmpList = new ArrayList<>();
    
    static int cnt = 0;
    
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String word) {
        
        recursive();
                
        return hashMap.get(word);
        
        
    }
    
    static void recursive() {
        
        
        for (int i = 1; i <= 5; i++) {
            
            tmpList.add(i);
            marking();
            
            if (tmpList.size() < 5)
                recursive();
            
            tmpList.remove(tmpList.size() - 1);
            
            
        }
        
    }
    
    static void marking() {
        
        cnt++;
        
        for (int value : tmpList) {
            
            String stringValue = value == 1 ? "A" : value == 2 ? "E" : value == 3 ? "I" : value == 4 ? "O" : "U";
            
            sb.append(stringValue);
            
        }
        
        hashMap.put(sb.toString(), cnt);
    
        sb.setLength(0);
    }
    
    
    
}