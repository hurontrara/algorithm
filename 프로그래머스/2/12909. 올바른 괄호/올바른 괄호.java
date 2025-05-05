import java.util.*;

class Solution {
    
    int state;
    
    boolean solution(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            
            char letter = s.charAt(i);
            
            state = (letter == '(') ? state + 1 : state - 1;
                        
            if (state < 0)
                return false;
            
        }
        
        if (state > 0)
            return false;
        
        return true;
        
    }
}