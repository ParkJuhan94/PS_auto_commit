class Solution {
    public int solution(int[] a) {
        int answer = 2; //맨 왼쪽, 오른쪽은 전부 가능
        
        //풍선들을 1개만 남을 때까지 터트렸을 때 최후까지 남기는 것이 가능한 풍선들의 개수를 return
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        //i일 때 왼쪽 최솟값 저장
        int min = a[0];
        for(int i=1; i<a.length-1; i++){
            left[i] = min;
            if(a[i] < min){
                min = a[i];
            }
        }
        
        //i일 때 오른쪽 최솟값 저장
        min = a[a.length-1]; 
        for(int i=a.length-2; i>0; i--){
            right[i] = min;
            if(a[i] < min){
                min = a[i];
            }
        }
        
        //양 옆의 최솟값이 둘 다 i 보다 작으면 불가능.
        for(int i=1; i<a.length-1; i++){
            if(left[i] < a[i] && right[i] < a[i]) continue;
            answer++;
        }
        
        return answer;
    }
}