import java.util.*;

class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        // 세로 길이 기준
        for (int i = 3; i <= total / 2; i++) {
            
            // 가로 길이는
            int j = total / i;
            
            if (total % i == 0 && ((i * 2) + (j * 2) - 4) == brown) {
                
                answer[0] = j; answer[1] = i;
                
                return answer;
                
            }
            
        }
        
        return null;
        
        
    }
}

// brown + yellow = 전체 넓이
// 가로 최소 3, 세로 최소 3
// 넓이 12이고 가로 3일 때, 세로 4 이고, brown 갯수 구할 수 있음 : 가로 * 2 + 세로 * 2 - 4
// 완전탐색 조져서 brown 갯수 같으면 ㄱ