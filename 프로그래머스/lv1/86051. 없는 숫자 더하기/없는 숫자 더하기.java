class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i = 1; i <= 9; i++){
            int flag = 0;
            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                System.out.println(i);
                answer += i;
            }
        }
        
        return answer;
    }
}