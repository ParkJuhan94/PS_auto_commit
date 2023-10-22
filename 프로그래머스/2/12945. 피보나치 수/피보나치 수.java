class Solution {
    int[] fibos = new int[100001];
    
    public int solution(int n) {
        fibos[1] = 1;
        fibos[2] = 1;
        
        return fibo(n) % 1234567;
    }
    
    public int fibo(int n) {
        
        if(fibos[n] != 0){
            return fibos[n];
        }
    
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        
      
    
        return fibos[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567;
    }
}