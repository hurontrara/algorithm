import java.util.*;

class Solution {
    
    String answer = "";
    
    public String solution(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            
            char tmp = s.charAt(i);
            
            // 변환 대상인지... 1) 맨 앞에 있고 2) 소문자 --> 대문자화
            // 변환 대상인지... 1) 맨 앞이 아니고 2) 대문자 --> 소문자화
            if ((i == 0 || s.charAt(i - 1) == ' ') && isSmall(tmp)) {
                
                tmp -= 32;
                
            } else if ((i > 0 && s.charAt(i - 1) != ' ') && isBig(tmp)) {
                
                tmp += 32;
                
            }
            
            answer += String.valueOf((char) tmp);
            
        }
        
        return answer;
        
        
    }
    
    boolean isBig(char c) {
        return c >= 'A' && c <= 'Z';
    }

    boolean isSmall(char c) {
        return c >= 'a' && c <= 'z';
    }
    
    
    
}

// 65 90
// 97 122