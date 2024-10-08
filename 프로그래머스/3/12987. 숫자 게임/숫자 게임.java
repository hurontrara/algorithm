import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = B.length - 1;
        for (int i = B.length - 1; i >= 0; i--) {
        
            if (B[index] > A[i]) {
                
                index--;
                answer++;
                
            } 
                
                        
            
        }
        
        return answer;
        
    
    }
}

// 최대 점수를 얻으려면 ?
// 최댓값에 대하여 잘 쳐내야함