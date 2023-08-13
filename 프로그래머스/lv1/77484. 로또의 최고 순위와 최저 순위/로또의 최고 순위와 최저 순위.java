class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cntZero = 0;
        int cntSame = 0;

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                cntZero++;
            }
        }

        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    cntSame++;
                    break;
                }
            }
        }

        if(cntSame + cntZero <= 1){
            answer[0] = 6;   
        }else{
            answer[0] = 6 - (cntSame + cntZero) + 1;    
        }
        
        if(cntSame <= 1){
            answer[1] = 6;    
        }else{
            answer[1] = 6 - cntSame + 1;   
        }
        
        return answer;
    }
}
