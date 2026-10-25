import java.util.*;

class Solution {
    
    int[][] matrix;
    int answer = 0;
    int idx = 0;
    
    public int solution(int[][] routes) {
        
        matrix = routes; 
        Arrays.sort(matrix, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        
        while (!(idx >= matrix.length)) {
            
            greedy(); answer++;
                        
        }
        
        return answer;
        
        
    }
    
    void greedy() {
        
        // 첫번째 항 값 가져옴 AND 제거
        // 나머지 항 들에 대하여(인덱스) a[0] 값이 앞에 있으면 제거 그거 아니면 반복문 그만
        
        int[] firstArray = matrix[idx]; idx++;
        
        for (int i = idx; i < matrix.length; i++) {
            
            if (matrix[i][0] <= firstArray[1]) {
                
                idx++;
                
            } else {
                return;
            }
            
        }
        
        
    }
    
    
    
    
}