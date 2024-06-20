import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int[] valueArray;
    static int answer = 0;
    
    static List<Integer> localValue = new ArrayList<>();
    
    public int solution(String[][] clothes) {
        
        for (String[] array : clothes) {
            String name = array[1];
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }
        
        if(hashMap.size() == 30){ return 1073741823; }
        
        valueArray = new int[hashMap.size()];
        int idx = 0;
        for (int value : hashMap.values()) {
            valueArray[idx++] = value;
        }
        
        backTracking(0);
        
        return answer;
        
    }
    
    static void backTracking(int index) {
        
        if (index == valueArray.length) {
            
            if (localValue.isEmpty())
                return;
        
            answer += getMultiple();
            
            return;
            
        }
        
        // 포함하지 않는 경우
        backTracking(index + 1);
        
        // 포함하는 경우
        localValue.add(valueArray[index]);
        backTracking(index + 1);
        localValue.remove(localValue.size() - 1);
        
        
        
    }
    
    static int getMultiple() {
        
        int answer = 1;
        
        for (int value : localValue) {
            answer *= value;
        }
        
        return answer;
        
        
    }
}

