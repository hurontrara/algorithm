// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 true
import java.io.*;
import java.util.*;


class Solution {
    
    
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            
            String before = phone_book[i]; String after = phone_book[i + 1];
            
            if (check(before, after)) {
                return false;
            }
            
        }
        
        return true;
        
        
    }
    
    
    static boolean check(String before, String after) {
        // before가 after의 접두어인지
        
        if (before.length() >= after.length())
            return false;
        
        for (int i = 0; i < before.length(); i++) {
            
            char beforeChar = before.charAt(i); char afterChar = after.charAt(i);
            
            if (beforeChar != afterChar)
                return false;
            
        }
        
        return true;
        
        
    }
}