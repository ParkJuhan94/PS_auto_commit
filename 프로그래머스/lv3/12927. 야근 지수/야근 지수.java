import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for(int i = 0; i < len; i++){
            sum += works[i];
            pq.add(works[i]);
        }
        // 남은 시간동안 할 수 있는 작업량 빼기
        sum -= n;
        if(sum <= 0){   // 할 야근이 없으면 0리턴
            return 0;
        }

        // 야근 분배하기
        while(n-- > 0){
            int cur = pq.poll();
            cur--;
            pq.add(cur);
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer += Math.pow(cur, 2);
        }

        return answer;
    }
}

// 99, [2, 15, 22, 55, 55], 580