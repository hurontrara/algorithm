import java.util.*;

// dp[i][j] = Max(dp[i - 1][all that not j] + land[i][j])

class Solution {
    
    int[][] dp;
    int answer = 0;
    
    int solution(int[][] land) {

        dp = land;
        
        for (int i = 1; i < dp.length; i++) {
            for (int ii = 0; ii < 4; ii++) {
                
                int beforeMax = 0;
                for (int iii = 0; iii < 4; iii++) {
                    
                    if (ii == iii) {
                        continue;
                    }
                    
                    beforeMax = Math.max(beforeMax, dp[i - 1][iii]);
                    
                }
                dp[i][ii] = beforeMax + land[i][ii];
                
            }
        }
        
        for (int i = 0; i < 4; i++) {
            
            answer = Math.max(answer, dp[dp.length - 1][i]);
            
        }
        
        return answer;
    }
    
    
}