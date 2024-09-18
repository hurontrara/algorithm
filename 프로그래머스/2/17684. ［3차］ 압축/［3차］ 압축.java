import java.util.*;

class Solution {
    
    static int index = 27;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    
    static List<Integer> answer = new ArrayList<>();
        
    public List<Integer> solution(String msg) {
        
        for (int i = 65; i < 97; i++) {
            
            char charAlphabet = (char) i;
            
            hashMap.put(String.valueOf(charAlphabet), i - 64);
            
        }
        
        String localString = "";
        for (int i = 0; i < msg.length(); i++) {
            
            localString += String.valueOf(msg.charAt(i));
            
            if (i < msg.length() - 1 ) {
                
                    if (hashMap.containsKey(localString + String.valueOf(msg.charAt(i + 1)))) {
                
                        continue;
                
                    } else {
                        
                        hashMap.put(localString + String.valueOf(msg.charAt(i + 1)), index++);
                        answer.add(hashMap.get(localString));
                        localString = "";
                         

                    }
            }
            
        }
        
        if (!localString.equals("")) {
            
            answer.add(hashMap.get(localString));
            
            
        }
        
        
        
        return answer;
    }
    
    
}

// 1. 압축 할 수 있는 것 찾기
// 2. 압축 및 출력