import java.util.*;

class Solution {
    
    static int[] visited;
    static List<Integer> tmpList = new ArrayList<>();
    
    static int[] indexList;
    
    static int answer = 0;
    
    static int[][] dungeonGlobal;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new int[dungeons.length];
        indexList = new int[dungeons.length];
        
        dungeonGlobal = dungeons;
        
        for (int i = 0; i < dungeonGlobal.length; i++) {
            indexList[i] = i;
        }
        
        recursive(k);
        
        return answer;
        
        
        
    }
    
    static void recursive(int k) {
        
        if (tmpList.size() == dungeonGlobal.length) {
            
            
            int cnt = 0;
            int localK = k;
            for (int i = 0; i < dungeonGlobal.length; i++) {
                
                int[] localDungeon = dungeonGlobal[tmpList.get(i)];
                
                if (!canGo(localDungeon, localK)) {
                
                    break;
                                        
                }
                
                cnt++;
                localK -= localDungeon[1];

            }
            
            answer = Math.max(answer, cnt);
            
            return;
        
            
        }
        
        
        for (int i = 0; i < dungeonGlobal.length; i++) {
            
            if (visited[i] == 1)
                continue;
            
            tmpList.add(i);
            visited[i] = 1;
            
            recursive(k);
            
            tmpList.remove(tmpList.size() - 1);
            visited[i] = 0;
            
        }
        
    }
    
    static boolean canGo(int[] dungeon, int k) {
        
        
        return k >= dungeon[0];
        
    }
    
    
}