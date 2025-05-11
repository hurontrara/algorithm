import java.util.*;

class Solution {
    
    int firstRow, firstCol, secondRow, secondCol;
    
    int[][] answer;
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        firstRow = arr1.length; firstCol = arr1[0].length;
        secondRow = arr2.length; secondCol = arr2[0].length;
        
        answer = new int[firstRow][secondCol];
        
        for (int i = 0; i < firstRow; i++) {
            for (int ii = 0; ii < secondCol; ii++) {
                
                int value = 0;
                for (int iii = 0; iii < firstCol; iii++) {
                    value += arr1[i][iii] * arr2[iii][ii];
                }
                answer[i][ii] = value;
                
            }
        }
        
        return answer;
      
        
    }
    
    
}