import java.util.*;

class Solution {
    
    static Stack<Integer> stack = new Stack<>();
    static int[] baseArray;
    
    public Stack<Integer> solution(int[] progresses, int[] speeds) {
        
        baseArray = new int[speeds.length];
        
        for (int i = 0; i < baseArray.length; i++) {
            
            baseArray[i] = (int) Math.ceil(((100 - progresses[i]) / (float) speeds[i]));
            
            if (i >= 1 && baseArray[i] < baseArray[i - 1]) {
                baseArray[i] = baseArray[i - 1];
            }
            
        }
        
                
        stack.add(1);
        
        for (int i = 1; i < baseArray.length; i++) {
            
            int left = baseArray[i - 1];
            int right = baseArray[i];
            
            
            if (left == right) {
                stack.add(stack.pop() + 1);
            } else {
                stack.add(1);
            }
            
        }
        
        return stack;
        
        
    }
}

// [7, 3, 9] -> [7, 7, 9]
// [5, 10, 1, 1, 20, 1]

// 1 넣고 시작 -> 왼쪽께 크거나 같으면 꺼내서 +1 하고 넣기
// 왼쪽께 작으면 1넣기