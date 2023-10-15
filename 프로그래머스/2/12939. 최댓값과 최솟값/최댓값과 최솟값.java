class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < sArr.length; i++){
            int n = Integer.parseInt(sArr[i]);
            
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }
        
        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);
        
        return answer;
    }
}