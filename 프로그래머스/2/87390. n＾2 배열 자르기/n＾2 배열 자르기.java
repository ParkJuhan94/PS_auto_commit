import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            // 인덱스 계산하기
            long row = i / n;
            long col = i % n;
            // 문제의 규칙
            answer[idx++] = Math.max((int) row, (int) col) + 1;
        }

        return answer;

    }
}