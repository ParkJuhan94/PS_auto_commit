class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;    // 기지국 인덱스
        int pos = 1;    // 탐색중인 인덱스

        // 시간 복잡도를 위해서 N 탐색해야한다
        while(pos <= n){
            if(idx < stations.length && stations[idx] - w <= pos)
            {
                // 전파 되는 경우 : pos 증가 + 다음 기지국으로 인덱스 이동
                pos = stations[idx] + w + 1;
                idx++;
            }else {
                // 전파 안되는 경우 : 기지국 설치 + pos 증가
                pos += (2 * w + 1);
                answer++;
            }
        }

        return answer;
    }
}