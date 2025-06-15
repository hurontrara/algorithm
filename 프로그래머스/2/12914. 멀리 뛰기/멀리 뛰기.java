import java.util.*;

class Solution {
    
    int[] array;
    
    public long solution(int n) {
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        array = new int[n + 1];
        
        array[1] = 1; array[2] = 2;
        
        for (int i = 3; i < n + 1; i++) {
            
            array[i] = (array[i - 1] + array[i - 2]) % 1234567;
            
        }
        
        return array[n];
        
        
    }
}