import java.util.*;

class Ball {
    
    int priority;
    int location;
    
    Ball(int priority, int location) {
        
        this.priority = priority;
        this.location = location;
        
    }
    
}


class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Queue<Ball> queue = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {
        
        for (int i = 0; i < priorities.length; i++) {
            
            queue.add(new Ball(priorities[i], i));
            pq.add(-1 * priorities[i]);
            
        }
        
        for (int i = 1; i < priorities.length + 1; i++) {
            
            int targetPriority = -1 * pq.poll();
            
            Ball ball = null;
            
            while (true) {
                
                ball = queue.poll();
                
                if (ball.priority == targetPriority) {
                    
                    break;
                    
                }
                
                queue.add(ball);
                
            }
            
            if (ball.location == location) {
                
                return i;
            }
            
            
            
        }
        
        return 3;
        
        
        
    }
    
    
    
    
}


// 지금 원소가 남은 원소들 중에서 가장 큰건지는 어떻게 알아? -> 우선순위 큐
// 우선순위 큐에서 꺼내고 -> 객체들끼리 꺼내고 넣고 반복