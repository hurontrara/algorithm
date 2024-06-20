import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> hashMap = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        
        for (int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            
            String person = completion[i];
            int value = hashMap.get(person);
            
            if (value == 1)
                hashMap.remove(person);
            else
                hashMap.put(person, hashMap.get(person) - 1);
        }
        
        for (String key : hashMap.keySet()) {
            return key;
        }        
        
        return null;
        
    }
}