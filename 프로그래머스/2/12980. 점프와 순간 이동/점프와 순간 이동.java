import java.util.*;


public class Solution {
    public int solution(int n) {

        return cal(n);
    }
    
    
    int cal(int n) {
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // 홀수
        if (n % 2 == 1) {
            return cal(n - 1) + 1;
        } 
        
        return cal(n / 2);
        
        
    }
}