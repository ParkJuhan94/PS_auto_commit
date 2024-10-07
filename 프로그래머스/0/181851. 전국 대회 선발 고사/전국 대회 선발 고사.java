import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> rank[i]));
        
        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]) {
                pq.add(i);
            }
        }
        
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();
        
        return 10000 * a + 100 * b + c;
    }
}