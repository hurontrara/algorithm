import java.util.*;



class Solution {
    
    
    public List<Integer> solution(int[] answers) {
        
        List<Integer> firstList = init(1); List<Integer> secondList = init(2); List<Integer> thirdList = init(3);
        
        
        return compare(answers, firstList, secondList, thirdList);
        
    }
    
    List<Integer> compare(int[] answers, List<Integer> firstList, List<Integer> secondList, List<Integer> thirdList) {
        
        int first = 0, second = 0, third = 0;
        
        for (int i = 0; i < answers.length; i++) {
            
            int answer = answers[i];
            
            if (answer == firstList.get(i)) {
                first++;
            }
            
            if (answer == secondList.get(i)) {
                second++;
            }

            
            if (answer == thirdList.get(i)) {
                third++;
            }
    

        
        }
        
        List<Integer> returnAnswer = new ArrayList<>();
        
        int max = Math.max(first, Math.max(second, third));
        
        if (first == max) {
            returnAnswer.add(1);
        }
        if (second == max) {
            returnAnswer.add(2);
        }
        if (third == max) {
            returnAnswer.add(3);
        }

        return returnAnswer;
        
    }
    
    
    
    List<Integer> init(int value) {
        
        List<Integer> initList = new ArrayList<>();
        
        if (value == 1) {
            
            for (int i = 0; i < 2000; i++) {
                
                
                initList.addAll(Arrays.asList(1,2,3,4,5));
                
            }
            
        }
        else if (value == 2) {
            
            for (int i = 0; i < 1500; i++) {
                
                initList.addAll(Arrays.asList(2,1,2,3,2,4,2,5));
                
            }

        }
        else {
            
            for (int i = 0; i < 1000; i++) {
                
                initList.addAll(Arrays.asList(3,3,1,1,2,2,4,4,5,5));

            }            
            
        }
        
        return initList;
        
        
    }
    
    
    
}