import java.util.*;

class Solution {
    
    
    HashSet<String> hashSet = new HashSet<>();
    
    // U, R, D, L
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int[][] matrix = new int[11][11];
    boolean[][] visited =  new boolean[11][11];
    
    int answer = 0;
    
    int x = 5; int y = 5;
    
    public int solution(String dirs) {
        
        visited[5][5] = true;
        
        for (int i = 0; i < dirs.length(); i++) {
            
            char c = dirs.charAt(i);
            
            move(c);

        }
        
        
        return answer;
    }
    
    void move(char c) {
        
        int dir = 0;
        if (c == 'U') {
            dir = 0;
        }
        if (c == 'R') {
            dir = 1;
        }
        if (c == 'D') {
            dir = 2;
        }
        if (c == 'L') {
            dir = 3;
        }
    
    
        int postX = x + dx[dir];
        int postY = y + dy[dir];
        
        
        
        if (postX >= 0 && postX < 11 && postY >= 0 && postY < 11) {
            
            String path = String.valueOf(x) + String.valueOf(y) + String.valueOf(postX) + String.valueOf(postY);
            String path2 = String.valueOf(postX) + String.valueOf(postY) + String.valueOf(x) + String.valueOf(y);
            
            if (!hashSet.contains(path)) {
                
                hashSet.add(path);
                hashSet.add(path2);

                answer++;
            }
            
            x = postX; y = postY;
            
        }
        
        
        
        visited[x][y] = true;
        
        
    }
    
    
}