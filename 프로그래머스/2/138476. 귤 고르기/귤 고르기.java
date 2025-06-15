import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    int before = 0;
    int cnt = 1;
    
    public int solution(int k, int[] tangerine) {
        
        if (tangerine.length == 1)
            return 1;
        
        Arrays.sort(tangerine);
        
        before = tangerine[0];
        
        for (int i = 1; i < tangerine.length; i++) {
            
            if (tangerine[i] == tangerine[i - 1]) {
                cnt++;
            } else {
                list.add(cnt);
                before = tangerine[i];
                cnt = 1;
            }
            
        }
        
        list.add(cnt);
        
        Collections.sort(list);
        
        int answer = 0;
        cnt = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            
            cnt++;
            answer += list.get(i);
            
            if (answer >= k) {
                return cnt;
            }
            
        }
        
        return 0;
        
        
    }
    
    
}