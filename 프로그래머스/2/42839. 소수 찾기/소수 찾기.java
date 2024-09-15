import java.util.*;

class Solution {
    
    static List<Character> tmpList = new ArrayList<>();
    static int size;
    static int[] visited;
    static String string;
    
    static HashSet<Integer> hashSet = new HashSet<>();
    
    static int answer = 0;
    
    static StringBuilder sb = new StringBuilder();
    
    public int solution(String numbers) {
        
        size = numbers.length();
        visited = new int[size];
        string = numbers;
        
        for (int i = 1; i <= numbers.length(); i++) {
            
            recursive(i);   
            
        }
        
        
        return answer;
        
    }
    
    static void recursive(int count) {
        
        if (tmpList.size() == count) {
            
            
            for (char character : tmpList) {
                
                sb.append(character);
                
            }
            
            String localString = sb.toString(); sb.setLength(0);
            
            answer += isPrime(Integer.parseInt(localString));
            
            return;
        }
        
        for (int i = 0; i < size; i++) {
            
            if (visited[i] == 1)
                continue;
            
            visited[i] = 1;
            tmpList.add(string.charAt(i));
            
            recursive(count);
            
            visited[i] = 0;
            tmpList.remove(tmpList.size() - 1);
            
            
        }

        
    }
    
    static int isPrime(Integer value) {
        
        if (value <= 1 || hashSet.contains(value)) {
            return 0;
        }
        
        
        for (int i = 2; i <= (int) Math.sqrt(value); i++) {
            
            if (value % i == 0)
                return 0;
            
        }
        
        hashSet.add(value);
        
        return 1;
        
        
    }
    
    
}