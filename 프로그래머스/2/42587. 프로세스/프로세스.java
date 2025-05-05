import java.util.*;

class Point {
    
    int number;
    int location;
    
    Point(int number, int location) {
        
        this.number = number;
        this.location = location;
    }
    
    
}

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<Point> queue = new LinkedList<>();
    
    int answer = 1;
    
    public int solution(int[] priorities, int location) {
        
        int local = 0;
        for (int value : priorities) {
            
            pq.add(-1 * value);
            queue.add(new Point(value, local++));
            
            
        }
        
        
        
        for (int i = 1; i <= priorities.length; i++) {
            
            int value = pq.poll() * -1;
            
            while (true) {
                
                Point point = queue.poll();
                
                if (point.number != value) {
                    queue.add(point);
                }
                else {
                    
                    if (point.location == location) {
                        
                        return answer;
                    }
                    
                    answer++;
                    break;
                }
                
            }
            
            
            
            
        }
        
        return 0;
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}