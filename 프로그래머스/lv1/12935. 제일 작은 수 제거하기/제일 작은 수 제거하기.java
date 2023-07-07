class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int answerIdx = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        
        if(arr.length == 1){ 
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                minIdx = i;                    
            }
        }
        
    
        for(int i = 0; i < arr.length; i++){
            if(i != minIdx){
                answer[answerIdx++] = arr[i];
            }
        }    
        
        
        return answer;
    }
}