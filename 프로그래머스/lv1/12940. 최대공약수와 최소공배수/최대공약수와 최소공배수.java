class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int num1 = 1;
        int num2 = 1;
        
        int small = Math.min(n,m);
        for(int i = 1; i <= small; i++){
            if(n % i == 0 && m % i == 0){
                num1 = i;
            }
        }
        num2 = n * m / num1;
        
        answer[0] = num1;
        answer[1] = num2;
        
        return answer;
    }
}