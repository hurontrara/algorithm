import java.util.*;

class Solution {
    
    Stack<Character> stack = new Stack<>();
    
    public int solution(String s) {
        
        stack.add(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            
            char input = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.add(input);
            } else if (input == stack.peek()) {
                stack.pop();
            } else {
                stack.add(input);
            }
            
            
        }
        
        return stack.size() == 0 ? 1 : 0;
        

    }
}