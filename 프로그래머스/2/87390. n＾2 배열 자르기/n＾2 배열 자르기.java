import java.util.*;

class Solution {
    
    static List<Integer> list = new ArrayList<>();
    
    public List<Integer> solution(int n, long left, long right) {
        
        for (long i = left + 1; i <= right + 1; i++) {
            
            long row = (i - 1) / n;
            long col = (i - 1) % n;
            
            list.add(Math.max((int) row + 1, (int) col + 1));
            
            
        }
        
        return list;
        
        
    }
    
    
}

// 행, 열 중 큰 값이 들어감

// n = 2 : 1 2 2 2
// n = 3 : 1(0행0열) 2(0행1열) 3(0행2열) 2(1행0열) 2 3(1행2열) 3(2행0열) 3 3

// 2번째가 몇행 몇열인지 ? 0행 2 - 1열
// 5번째가 몇행 몇열인지 ? (1행 1열) 
// 4 * 4에서 11번은 ? 2행 3 - 1열