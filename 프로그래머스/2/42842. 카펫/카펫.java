import java.util.*;


class Solution {
    
    int total; // 총 면적
    
    public int[] solution(int brown, int yellow) {
        
        total = brown + yellow;
        
        for (int i = 1; i <= total; i++) {
            
            if (total % i == 0) {
                
                int row = total / i;
                int col = i;
                
                int sYellow = (row - 2) * (col - 2);
                
                if (sYellow == yellow) {
                    
                    return new int[]{row, col};
                }
                
                
            }
            
            
        }
        
        return null;
        
        
        
    }
    
    
}