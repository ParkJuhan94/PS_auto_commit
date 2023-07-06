class Solution {
    public int solution(int num) {
        int answer = 0;
        long lnum = (long)num;
        
        while(true){
            if(lnum == 1){
                break;
            }
            if(lnum % 2 == 0){
                lnum /= 2;
            }else{
                lnum *= 3;
                lnum++;
            }
            if(answer == 500){
                answer = -1;
                break;
            }
            answer++;
        }
        
        return answer;
    }
}