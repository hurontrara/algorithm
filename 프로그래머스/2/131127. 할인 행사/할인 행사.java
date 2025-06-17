import java.util.*;

class Solution {
    
    Map<String, Integer> wantMap = new HashMap<>();
    Map<String, Integer> discountMap = new HashMap<>();
    
    int answer = 0;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        // 1. wantMap 초기화 : {'banana' : 3, 'apple' : 2} ...
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 2. discountMap 초기화
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        // 3. 가능 여부 체크하고
        // 4. discountMap 수정
        
        for (int i = 9; i < discount.length; i++) {
            
            boolean check = true;
            for (String value : wantMap.keySet()) {
                
                int wantNum = wantMap.get(value);
                int discountNum = discountMap.getOrDefault(value, 0);
                
                if (wantNum > discountNum) {
                    check = false;
                    break;
                }
                
            }
            
            if (check) answer++;
            if (i == discount.length - 1) break;
            
            // 추가
            discountMap.put(discount[i + 1], discountMap.getOrDefault(discount[i + 1], 0) + 1);
            discountMap.put(discount[i - 9], discountMap.get(discount[i - 9]) - 1);

        }
        
        return answer;
    }
}