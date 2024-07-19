import java.util.*;

class Solution {
    
    static int small = -1;
    static int big = -1;
    
    public int solution(int[][] sizes) {
        
        for (int[] array : sizes) {
            
            int localSmall = Math.min(array[0], array[1]);
            int localBig = Math.max(array[0], array[1]);
            
            small = Math.max(small, localSmall);
            big = Math.max(big, localBig);
            
        }      
        
        return small * big;

    }
    
}

// 50 60
// 30 70
// 30 60
// 40 80

// 5 15
// 7 10
// 3 12
// 8 15
// 7 14

// 4 14 
// 6 19
// 6 16
// 7 18
// 7 11