import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    static int dir = 0;
    
    static int[][] matrix;
    
    static int row = -1;
    static int col = 0;
    
    static int number = 1;
    
    static List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(int n) {
        
        matrix = new int[n][n];
        
        while (number <= (n * (n + 1) / 2)) {


            if (!existCheck(n)) {
                
              dir = (dir + 1) % 3;
                
                
            } 
            
            matrix[row + dx[dir]][col + dy[dir]] = number++;
            row += dx[dir]; col += dy[dir];
                        
            
        }
        
        
        // 정답 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (matrix[i][j] != 0)
                    answer.add(matrix[i][j]);
                
            }
        }
        
        
        return answer;
    
    
    }
    
    static boolean existCheck(int n) {
        
        int row1 = row + dx[dir];
        int col1 = col + dy[dir];
        
        return row1 >= 0 && row1 < n && col1 >= 0 && col1 < n && matrix[row1][col1] == 0;
        
    }
}

// 4 일때 10
// 5 일때 15
// n(n - 1) / 2 개...