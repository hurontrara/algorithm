import java.util.*;

class Solution {
    
    int answer = 0;
    List<Integer> C = new ArrayList<>(); // B의 역정렬
    
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A); Arrays.sort(B);
        makeC(B);
        
        for (int i = 0; i < A.length; i++) {
            
            answer += (A[i] * C.get(i));
            
        }

        return answer;
    }
    
    void makeC(int[] B) {
        
        for (int i = B.length - 1; i >= 0; i--) {
            
            C.add(B[i]);
            
        }
        
        
    }
}