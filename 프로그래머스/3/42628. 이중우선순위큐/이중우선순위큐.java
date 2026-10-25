import java.util.*;

class Point implements Comparable<Point> {
    
    int value;
    int seq;
    
    Point(int value, int seq) {
        this.value = value;
        this.seq = seq;
    }
    
    public int compareTo(Point point) {
        
        return this.value - point.value;
        
    }
    
    
}


class Solution {
    
    TreeSet<Point> set = new TreeSet<>();
    int[] answer;
    int idx = 0;
    
    
    public int[] solution(String[] operations) {
        
        answer = new int[2];
        
        for (String operation : operations) {
            
            work(operation, idx);
            idx++;
            
        }
        
        if (!set.isEmpty()) {
            
            answer[1] = set.first().value; answer[0] = set.last().value;
            
        }
        
        return answer;
    }
    
    
    void work(String operation, int idx) {
        
        if (operation.charAt(0) == 'I') {
            
            set.add(new Point(Integer.valueOf(operation.substring(2)), idx));
            
        }
        else if (operation.charAt(2) == '1') {
            
            if (set.size() == 0) {return;}
            
            set.remove(set.last());
            
        }
        else {
            
            if (set.size() == 0) {return;}
            
            set.remove(set.first());
            
        }
        
        
    }
    
    
}