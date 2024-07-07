import java.util.*;

public class Solution {
    
    static Stack<Integer> stack = new Stack<>();
    static int[] answer;
    
    public int[] solution(int[] arr) {
        
        stack.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            
            if (arr[i] != stack.peek()) {
                stack.add(arr[i]);
            }
            
        }
        
        answer = new int[stack.size()];
        
        for (int i = answer.length - 1; i >= 0; i--) {
            
            answer[i] = stack.pop();
            
        }
        
        return answer;
        
        
    }
    
    
}