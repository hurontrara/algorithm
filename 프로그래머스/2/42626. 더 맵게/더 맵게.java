import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) {
        
        for (int value : scoville) {
            pq.add(value);
        }
        
        int cnt = 0;
        while (pq.size() != 0) {
            
            // 길이가 1이고 스코빌지수가 K 안되면 -1 리턴
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            
            // 하나만 봤을 때 K 넘으면 종료
            if (pq.peek() >= K)
                return cnt;
            
            // 제일 작은거 두개 섞는게 무조건 이득
            Integer left = pq.poll();
            Integer right = pq.poll();
            
            pq.add(left + (right * 2));
            cnt++;
            
            
            
        }
        
        return 555;
        
        
        
    }
    
    
    
    
    
    
}

// 길이가 1이고 스코빌지수가 K 안되면 -1 리턴
// 제일 작은거 두개 섞는게 무조건 이득