import java.util.*;

class Position {
    
    int x;
    int y;
    int state;
    
    Position(int x, int y, int state) {
        
        this.x = x;
        this.y = y;
        this.state = state;
        
    }
    
    
}



class Solution {
    
    boolean[][] visited;
    
    int globalState;
    
    boolean end = false;
    
    int answer = -1;
    
    Queue<Position> queue = new LinkedList<>();
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        int row = maps.length;
        int col = maps[0].length;
        visited = new boolean[row][col];
        
        queue.add(new Position(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty() && !end) {
            
            queueing(row, col, maps);
            
        }
        
        return answer;
        
    }
    
    void queueing(int row, int col, int[][] maps) {
        
        Position position = queue.poll();
            
        if (position.x == row - 1 && position.y == col - 1) {
            
            end = true;
            answer = position.state;
            
            return;
            
        }
        
        for (int dir = 0; dir < 4; dir++) {
            
            int futureX = position.x + dx[dir];
            int futureY = position.y + dy[dir];
            
            if (futureX >= 0 && futureX < row && futureY >= 0 && futureY < col && maps[futureX][futureY] == 1 && !visited[futureX][futureY]) {
                
                visited[futureX][futureY] = true;
                queue.add(new Position(futureX, futureY, position.state + 1));
                
            }
            
            
        }
        
        
        
            
    }
    
    
    
}