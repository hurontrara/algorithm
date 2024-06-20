import java.io.*;
import java.util.*;

class Solution {
    
    static HashSet<Integer> hashSet = new HashSet<>();
        
    public int solution(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        
        return Math.min(nums.length / 2, hashSet.size());
            
        
    }
    
    
}