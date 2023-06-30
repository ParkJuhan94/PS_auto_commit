class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int tmpX = x;
        int sum = 0;
        
         while(tmpX > 0){
                sum += tmpX % 10;
                tmpX /= 10;
            }
        
            if(x % sum == 0){
                answer = true;
            }else{
                answer = false;
            }    
        
        return answer;
    }
}