import java.util.*;

class Solution {
    
    int before; int after;
    
    public int solution(int n, int a, int b) {
        
        before = a; after = b;
        
        int answer = 1;
        while (true) {
            
            if ((before % 2 == 0 && (before - 1 == after)) || (after % 2 == 0 && (after - 1 == before)))  {
                return answer;
            } 
            
            answer++;
            process();
            
        }
    
    }
    
    void process() {
        
        if (before % 2 == 0) 
            before /= 2;
        else
            before = (before / 2) + 1;
        
        if (after % 2 == 0) 
            after /= 2;
        else
            after = (after / 2) + 1;

    
        
    }
    
}


// 1번 -> 1번
// 2번 -> 1번
// 3번 -> 2번
// 4번 -> 2번
// 5번 -> 3번