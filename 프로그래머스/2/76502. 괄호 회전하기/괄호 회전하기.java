import java.util.*;

class Solution {
        
    int answer = 0;
    Stack<Character> stack = new Stack<>();
    
    static String a;
    
    public int solution(String s) {
        
        a = s;
        
        if (s.length() == 1) return 0;
        
        for (int i = 0; i < a.length(); i++) {
            
            circulate();
            
            check();
        }
        
        return answer;
    }
    
    void check() {
        
        stack.clear();
        
        for (int i = 0; i < a.length(); i++) {
            
            char value = a.charAt(i);
            if (value == '[') {
                stack.add(value);
            }
            else if (value == '(') {
                stack.add(value);
            }
            else if (value == '{') {
                stack.add(value);
            }
            else if (value == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return;
                }
                stack.pop();
            }
            else if (value == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return;
                }
                stack.pop();
            }
            else if (value == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return;
                }
                stack.pop();
            }

            
        }
        
        if (stack.size() == 0) answer++;
        
    }
    
    void circulate() {
        
        a = a.substring(1, a.length()) + String.valueOf(a.charAt(0));
        
    }
    
}