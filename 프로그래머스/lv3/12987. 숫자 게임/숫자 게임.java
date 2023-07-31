import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        //a를 내림차순 정렬, b를 내림차순 정렬
        
        List<Integer> listA = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = A.length-1; i>=0; i--) {
            listA.add(A[i]);
        }
    
        for(int i = B.length-1; i>=0; i--) {
            q.addLast(B[i]);
        }
        
        int result = 0;
        
        for(int i = 0; i<listA.size(); i++) {
            if(listA.get(i) < q.peek() ){
                q.pollFirst();
                result++;
            }
        }
        
        return result;
        
        
    }
}