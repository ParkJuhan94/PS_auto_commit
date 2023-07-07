class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(cnt % 2 == 0){
                    answer += Character.toString(s.charAt(i)).toUpperCase();
                }else{
                    answer += Character.toString(s.charAt(i)).toLowerCase();
                }    
                cnt++;
            }else{
                answer += " ";
                cnt = 0;
            }                                  
        }
        
        return answer;
    }
}