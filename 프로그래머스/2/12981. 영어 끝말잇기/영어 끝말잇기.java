import java.util.*;

class Solution {
    
    public int[] solution(int n, String[] words) {    
        int[] answer = {0, 0};
        int[] count = new int[n + 1];
        int curPersonNum = 1;
        Set<String> enteredStrings = new HashSet<>();
        String word = words[0];
        
        enteredStrings.add(word);
        char lastChar = word.charAt(word.length() - 1);
        count[1]++;    
        
        for(int i = 1; i < words.length; i++){
            word = words[i];
            curPersonNum++;
            if(curPersonNum > n){
                curPersonNum = 1;
            }
            count[curPersonNum]++;
            
            if (enteredStrings.contains(word)) {
                // System.out.println("이미 입력한 문자열입니다.");
                answer[0] = curPersonNum;
                answer[1] = count[curPersonNum];
                break;
            } else {
                enteredStrings.add(word);
                 // System.out.println("새로운 문자열을 입력했습니다 : " + word);
            }
            
            if(lastChar != word.charAt(0)){
                answer[0] = curPersonNum;
                answer[1] = count[curPersonNum];
                break;
            }
            
            lastChar = word.charAt(word.length() - 1);
        }        
             
        return answer;
    }
}