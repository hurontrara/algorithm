import java.util.*;



class Solution {
    
    int total;
    
    int present;
    
    List<Integer> cList = new ArrayList<>();
    
    int answer;
    
    public int solution(int[] numbers, int target) {
        
        for (int value : numbers) {
            
            total += value;
            
        }
        
        combination(numbers, target, -1);
        
        return answer;
        
        
    }
    
    void combination(int[] numbers, int target, int state) {
        
        if (state == numbers.length) {
            return;
        }
        
        if (total - (2 * present) == target) {
            answer++;
        }
        
        
        
        
        for (int i = state + 1; i < numbers.length; i++) {
            
            present += numbers[i];
            
            combination(numbers, target, i);
            
            present -= numbers[i];
            
            
        }
        
        
    }
    
    
    
    
}