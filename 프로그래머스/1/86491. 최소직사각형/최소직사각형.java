import java.util.*;

class Solution {
    
    int row; int col;
    
    public int solution(int[][] sizes) {
        
        Arrays.stream(sizes).forEach(
        
            paper -> {
                
                int localRow = Math.max(paper[0], paper[1]);
                int localCol = Math.min(paper[0], paper[1]);
                
                row = Math.max(row, localRow);
                col = Math.max(col, localCol);
                
            }
        
        );
        
        
        return row * col;
    }
    
    
    
}