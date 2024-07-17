import java.util.*;

class Solution {
    
    static int answer = 0;
        
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        // 4 -> 1 , 3 -> 2
        int index = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            
            if (citations[i] >= index) {
                
                answer = index;
            }  
            
            index++;
        }
        
        
        return answer;
    }
    
    
    
}

// 3편의 논문이 3번 이상 인용되면 3
// 4편의 논문이 4번 이상 인용되면 4
// 등등
// 거꾸로 돌기