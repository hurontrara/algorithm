import java.util.*;

class Solution {
    
    String string;
    int answer;
    
    Stack<Character> stack = new Stack<>();
    
    public int solution(String s) {
        
        string = s;
        
        for (int i = 0; i < s.length(); i++) {
            
            rotate();
            check();
            
        }
        
        return answer;
        
                
        
        
    }
    
    void rotate() {
        
        string = string.substring(1, string.length()) + String.valueOf(string.charAt(0));
        
    }
    
    void check() {
        
        
        
        for (int i = 0; i < string.length(); i++) {
            
            char value = string.charAt(i);
            
            if (value == '[' || value == '(' || value == '{') { 
                
                stack.add(value); 
                continue;
            
            }
            
            if (value == ']') {
                
                if (stack.isEmpty() || stack.peek() != '[')
                    return;
                
                stack.pop();
                
            }
            
            if (value == '}') {
                
                if (stack.isEmpty() || stack.peek() != '{')
                    return;
                
                stack.pop();
                
            }

            if (value == ')') {
                
                if (stack.isEmpty() || stack.peek() != '(')
                    return;
                
                stack.pop();
                
            }
            
            
        }
        
        if (stack.size() == 0)
            answer++;
        
    }
    
    
}