import java.util.*;

class Point implements Comparable<Point> {
    
    int number;
    
    Point(int number) {
        
        this.number = number;
        
    }
    
    public int compareTo(Point point) {
        
        int a = Integer.parseInt(String.valueOf(this.number) + String.valueOf(point.number));
        int b = Integer.parseInt(String.valueOf(point.number) + String.valueOf(this.number));
        
        if (a > b)
            return -1;
        else if (a == b)
            return 0;
        else
            return 1;
        
    }
    
}

class Solution {
    
    List<Point> pList = new ArrayList<>();
    String answer = "";
    
    public String solution(int[] numbers) {
        
        for (int number : numbers) {
            pList.add(new Point(number));
        }
        
        Collections.sort(pList);
        
        for (Point point : pList) {
            
            answer += point.number;
            
        }
        
        if (answer.charAt(0) == '0')
            return "0";
        
        return answer;
        
        
        
    }
    
    
}