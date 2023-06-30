import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        String sortStr = "";
        for(int i = 0; i < list.size(); i++){
            sortStr += list.get(i);
        }
        answer = Long.parseLong(sortStr);
        
        return answer;
    }
}