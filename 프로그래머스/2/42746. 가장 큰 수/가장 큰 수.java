import java.util.*;

class Number implements Comparable<Number> {
    
    int value;
    
    Number(int value) {
        this.value = value;
    }
    
    
    @Override
    public int compareTo(Number number) {
        
        int left = Integer.parseInt(String.valueOf(this.value) + String.valueOf(number.value));
        int right = Integer.parseInt(String.valueOf(number.value) + String.valueOf(this.value));
        

        return right - left;
        
    }
    
    
}


class Solution {
    
    static Number[] numberArray;
    static StringBuilder sb = new StringBuilder();
    
    public String solution(int[] numbers) {
        
        numberArray = new Number[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            
            numberArray[i] = new Number(numbers[i]);
            
        }
        
        Arrays.sort(numberArray);
        
        for (Number number : numberArray) {
            
            sb.append(number.value);
            
        }
        
        String string = sb.toString();
        
        
        
        return string.charAt(0) == '0' ? "0" : string;
        
        
        
        
        
    }
    
    
    
}

// 