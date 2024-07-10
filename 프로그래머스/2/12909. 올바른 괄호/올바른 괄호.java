class Solution {
    
    static int value = 0;
    
    boolean solution(String s) {
        
        char[] array = s.toCharArray();
        
        for (char input : array) {
            
            if (input == '(')
                value++;
            else
                value--;
            
            if (value < 0)
                return false;
            
        }
        
        if (value != 0)
            return false;
        
        return true;
        
        
    }
}

// 끝났을 때 양수이거나, 중간에 음수인 경우