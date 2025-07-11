import java.util.*;

class Point {
    
    int x;
    int y;
    int distance;
    
    Point(int x, int y, int distance) {
        
        this.x = x;
        this.y = y;
        this.distance = distance;
        
    }
    
}

class Solution {
    
    boolean[][] visited;
    Queue<Point> queue = new LinkedList<>();
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    int globalRow, globalCol;
    
    public int solution(int[][] maps) {
        
        // 0. 초기 세팅
        globalRow = maps.length;
        globalCol = maps[0].length;
        visited = new boolean[globalRow][globalCol];
        
        // 1. 로직 초기화
        visited[0][0] = true;
        queue.add(new Point(0, 0, 1));
        
        // 2. 큐 굴리기
        while (!queue.isEmpty()) {
            
            Point point = queue.poll();
            
            if (point.x == globalRow - 1 && point.y == globalCol - 1) {
                                
                return point.distance;
                
            }
            
            for (int dir = 0; dir < 4; dir++) {
                
                int postRow = point.x + dx[dir];
                int postCol = point.y + dy[dir];
                
                if (check(postRow, postCol, maps)) {
                    queue.add(new Point(postRow, postCol, point.distance + 1));
                    visited[postRow][postCol] = true;
                }
                
            }
            
        }
        
        return -1;
        
        
    }
    
    boolean check(int row, int col, int[][] maps) {
        
        return row >= 0 && row < globalRow && col >= 0 & col < globalCol && visited[row][col] == false && maps[row][col] == 1;
        
    }
    
    
    
}