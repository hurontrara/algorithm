import java.util.*;

class Solution {
    
    String[] words;
    
    HashMap<String, Integer> dict = new HashMap<>();
    
    int cnt = 1;
    
    List<String> currentList = new ArrayList<>();
    
    public int solution(String word) {
        
        words = new String[]{"A", "E", "I", "O", "U"};
        
        permutation();
        
        return dict.get(word);
        
    }
    
    void permutation() {
        
        if (currentList.size() == 6) {
            
            return;
            
        }
        
        if (currentList.size() > 0) 
            dict.put(currentListToString(), cnt++);
        
        
        for (int i = 0; i < 5; i++) {
            
            currentList.add(words[i]);
            permutation();
            currentList.remove(currentList.size() - 1);
            
        }
        
        
    }
    
    String currentListToString() {
        
        String value = "";
        
        for (String str : currentList) {
            
            value += str;
            
        }
        
        return value;
        
        
    }
    
    
    
    
}