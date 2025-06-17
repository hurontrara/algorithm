import java.util.*;

class Solution {
    
    List<Integer> sumList = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        
        // 1. 누적합 리스트 만들기
        sumList.add(0);
        
        int sum = 0;
        for (int i = 0; i < elements.length * 2; i++) {
            sum += elements[i % elements.length];
            sumList.add(sum);
        }
        
        // 2. 연산 -> i는 길이
        for (int length = 1; length <= elements.length; length++) {
            
            for (int index = length; index <= length + elements.length; index++) {
                
                set.add(sumList.get(index) - sumList.get(index - length));
                                
            }
            
        }
        
        return set.size();
        
    }
    
    
    
}