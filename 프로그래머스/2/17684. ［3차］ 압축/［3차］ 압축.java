import java.util.*;


// 1. 사전에 있는 것까지 전진
// 2. 사전 추가 및 출력

class Solution {
    
    HashMap<String, Integer> hashMap = new HashMap<>();
    int index = 1;
    
    String tmp = "";
    List<Integer> aList = new ArrayList<>();
    
    public List<Integer> solution(String msg) {
         
        init();
        
        process(msg);
        
        return aList;
        
        
    }
    
    void process(String msg) {
        
        for (int i = 0; i < msg.length(); i++) {
            
            tmp += String.valueOf(msg.charAt(i));
            
            if (i == msg.length() - 1) {
                
                aList.add(hashMap.get(tmp));
                return;
                
            }
            
            String nextWord = String.valueOf(msg.charAt(i + 1));
            String sum = tmp + nextWord;
            
            
            if (hashMap.keySet().contains(sum)) {
                continue;
            } else {
                
                aList.add(hashMap.get(tmp));
                tmp = "";
                hashMap.put(sum, index++);
                
            }
            
            
        }
        
        
    }
    
    
    void init() {
        
        for (int i = 65; i < 91; i++) {
            
            hashMap.put(String.valueOf((char) i), index++);
            
        }
        
    }
    
    
}