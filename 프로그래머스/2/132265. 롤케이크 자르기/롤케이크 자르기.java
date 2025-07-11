import java.util.*;

class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    
    int answer = 0;
    
    public int solution(int[] topping) {
        
        // 1. map 초기화
        for (int i = 0; i < topping.length; i++) {
            
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            
        }
        
        
        // 2. 돌면서 1) map에서 제거하고 2) set에 더하고 3) 길이 체크
        for (int i = 0; i < topping.length; i++) {
            
            // 1) map에서 제거하고
            map.put(topping[i], map.get(topping[i]) - 1);
            
            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }
            
            // 2) set에 더하고
            set.add(topping[i]);
                
            // 3) 길이 체크
            if (set.size() == map.size()) answer++;
            
            
        }        
        
        return answer;
    }
    
    
    
}