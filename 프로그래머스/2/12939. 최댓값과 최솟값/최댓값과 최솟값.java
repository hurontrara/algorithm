import java.util.*;

class Solution {
    
    int buho = 1; // 1이거나 -1이거나
    
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    String tmpString = "";
    
    public String solution(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            
            char tmp = s.charAt(i);
            
            if (tmp == '-') {
                buho = -1;
                continue;
            } else if (tmp == ' ') {
                continue;
            }
            
            
            tmpString += String.valueOf(tmp);
            if (i == s.length() - 1 || s.charAt(i + 1) == ' ') {
                
                max = Math.max(max, buho * Integer.parseInt(String.valueOf(tmpString)));
                min = Math.min(min, buho * Integer.parseInt(String.valueOf(tmpString)));
            
                buho = 1;
                tmpString = "";
            } 
            
            
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
        

        
        
    }
    
    
    
}