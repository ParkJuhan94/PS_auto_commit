class Solution {
    public int[] solution(int brown, int yellow) {        
              
        int c;
        
        for(c = 1; c < 2000; c++){
            int sum = yellow - c * ((brown - 4) / 2 - c);
            if(sum == 0){
                break;
            }            
        }
        
        int r = (brown - 4) / 2 - c;
        
        int[] answer = new int[2];
        answer[0] = r + 2;
        answer[1] = c + 2;
            
        return answer;
    }
}