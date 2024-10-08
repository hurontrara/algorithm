import java.util.*;

class Solution {
    
    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();
    
    static int startRow, startCol, endRow, endCol = 0;
    
    static List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        
        matrix = new int[rows][columns];
        
        // 초기화
        int number = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                
                matrix[i][j] = number++;
                
            }
        }
        
        // 회전 및 작은 값 찾아서 넣기
        for (int[] query : queries) {
            
            startRow = query[0] - 1; startCol = query[1] - 1; endRow = query[2] - 1; endCol = query[3] - 1;
                        
            collect();
            
            answer.add(push());
            
            
            
            
            
        }
        
        
        return answer;
    }
    
    
    static void collect() {
        
        for (int j = startCol; j <= endCol; j++) {
            
            queue.add(matrix[startRow][j]);
            
        }
        
        for (int j = startRow + 1; j <= endRow; j++) {
            
            queue.add(matrix[j][endCol]);
            
        }

        for (int j = endCol - 1; j >= startCol; j--) {
            
            queue.add(matrix[endRow][j]);
            
        }

        for (int j = endRow - 1; j >= startRow + 1; j--) {
            
            queue.add(matrix[j][startCol]);
            
        }
        
    }
    
    static int push() {
        
        int min = Integer.MAX_VALUE;
        
        for (int j = startCol + 1; j <= endCol; j++) {
            
            int poll = queue.poll();
            min = Math.min(min, poll);
            
            matrix[startRow][j] = poll;
            
        }
        
        for (int j = startRow + 1; j <= endRow; j++) {
            
            int poll = queue.poll();
            min = Math.min(min, poll);

            matrix[j][endCol] = poll;
            
        }

        for (int j = endCol - 1; j >= startCol; j--) {
            
            int poll = queue.poll();
            min = Math.min(min, poll);

            matrix[endRow][j] = poll;
            
        }

        for (int j = endRow - 1; j >= startRow; j--) {
            
            int poll = queue.poll();
            min = Math.min(min, poll);

            matrix[j][startCol] = poll;
            
        }
        
        return min;
        
   
        
        
    }
    
}

// rows * columns 라는 행렬 존재
// 1. 회전 하고 
// 2. 가장 작은 수 저장