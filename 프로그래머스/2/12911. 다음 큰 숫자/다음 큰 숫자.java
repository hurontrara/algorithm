import java.util.*;

class Solution {
    
    int answer;
    int nOneNumber = 0;
    
    
    public int solution(int n) {
        
        answer = n;
        
        // 1. 1의 갯수 세기
        nOneNumber = countOneNumber(n);
        
        // 2. 계속 더하면서 체크
        while (true) {
            
            answer++;
            
            if (countOneNumber(answer) == nOneNumber) {
                break;
            }
            
        }
        
        return answer;
    }
    
    int countOneNumber(int n) {
        
        String binaryString = Integer.toBinaryString(n);
        
        int cnt = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
}