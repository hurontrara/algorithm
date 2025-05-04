import java.util.*;

class Solution {
    
    boolean[] visited;
    
    List<int[]> cList = new ArrayList<>();
    
    int max;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        
        permutation(k, dungeons);
        
        
        return max;
    }
    
    void calculate(int k) {
        
        int localK = k;
        int cnt = 0;
        
        for (int[] dungeon : cList) {
            
            if (localK >= dungeon[0]) {
                
                localK -= dungeon[1];
                cnt++;
                
                
            } else {
                
                break;
            }
            
        }
        
        max = Math.max(max, cnt);
        
        
        
    }
    
    
    void permutation(int k, int[][] dungeons) {
        
        if (cList.size() == dungeons.length) {
            
            calculate(k);
            
            return;
            
        }
        
        
        for (int i = 0; i < visited.length; i++) {
            
            if (!visited[i]) {
                
                visited[i] = true;
                cList.add(dungeons[i]);
                permutation(k, dungeons);
                cList.remove(cList.size() - 1);
                visited[i] = false;
                
                
            }
            
            
        }
        
        
    }
    
    
}