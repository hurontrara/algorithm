import java.util.*;

class Solution {
    
    static HashSet<Character> hashSet = new HashSet<>();
    static Queue<Character> queue = new LinkedList<>();
    
    static int answer = 0;
    
    public int solution(String skill, String[] skill_trees) {
        
        for (String tree : skill_trees) {
            
            // 초기화
            
            queue.clear();

            for (int i = 0; i < skill.length(); i++) {
                
                hashSet.add(skill.charAt(i));
                queue.add(skill.charAt(i));
                
            }
            
            boolean check = true;
            for (int i = 0; i < tree.length(); i++) {
                
                char target = tree.charAt(i);
                
                if (!hashSet.contains(target))
                    continue;
                
                if (queue.peek() == target) {
                    
                    queue.poll();
                    
                } else {
                    
                    check = false;
                    break;
                    
                }
                                
                
                
            }
            
            if (check)
                answer++;
            
            
        }
        
        return answer;
        
        
        
        
    }
}
