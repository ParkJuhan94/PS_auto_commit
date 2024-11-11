class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int currentEnd = 0; // 현재 칠한 영역의 끝 부분을 기록

        for (int i = 0; i < section.length; i++) {
            // 현재 칠한 영역의 끝 부분보다 작은 구역은 이미 칠해져 있으므로 스킵
            if (section[i] <= currentEnd) {
                continue;
            }
            
            // 새로 롤러를 사용해 칠해야 하는 경우
            answer++;
            currentEnd = section[i] + m - 1; // 롤러가 덮을 수 있는 새로운 끝 범위
        }
        
        return answer;
    }
}
