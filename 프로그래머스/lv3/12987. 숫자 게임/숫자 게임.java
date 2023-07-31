//package Programmers.Level_3.숫자게임;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 1 3 5 7
        // 2 2 6 8
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < A.length; i++){
            pqA.add(A[i]);
            pqB.add(B[i]);
        }

        while(true){
            if(pqA.isEmpty()){
                break;
            }

            // B에서 가장 높은 점수에 근접한 A의 점수를 찾는 로직
            if(pqA.peek() < pqB.peek()){
                pqA.poll();
                pqB.poll();
                answer++;
            }else{
                pqA.poll();
            }
        }

        return answer;
    }
}