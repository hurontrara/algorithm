import java.util.*;

class Solution {
    
    String start, end;
    String[] matrix;
    int answer[];
    Queue<String> queue = new LinkedList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String begin, String target, String[] words) {
        
        start = begin; end = target; matrix = words; answer = new int[matrix.length];
        
        queue.add(begin); map.put(begin, 1);
        
        for(int round = 0; round < words.length; round++) {
            
            bfs(round + 1);
            
        }
            
        
        return map.containsKey(end) ? map.get(end) : 0;

    }
    
    void bfs(int round) {
        
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            
            String str = queue.poll();
            // str하고, 반복문 돈 값하고 만약 글자가 하나만 다르고, 글자가 맵에 없다면 --> 맵에 추가 
            for (String target : matrix) {

                if (!map.containsKey(target) && check(str, target)) {

                    map.put(target, round);
                    queue.add(target);

                }

            }
            
        }
        
    }
    
    boolean check(String a, String b) {
        
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            
            if (a.charAt(i) != b.charAt(i)) { cnt++; }
            
        }
        
        return cnt == 1;
        
    }
    
    
}