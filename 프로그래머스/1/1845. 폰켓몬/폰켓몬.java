import java.util.*;

class Solution {
    
    HashSet<Integer> hashSet = new HashSet<>();
    
    public int solution(int[] nums) {
        
        int choice = nums.length / 2;
        
        for (int num : nums) {
            
            hashSet.add(num);
            
        }
        
        return Math.min(hashSet.size(), choice);
        
        
    }
    
    
}