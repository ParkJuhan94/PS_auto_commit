class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;    // 기지국 인덱스
        int pos = 1;    // 탐색중인 인덱스

        while(pos <= n){
            if(idx < stations.length && stations[idx] - w <= pos)
            {
                pos = stations[idx] + w + 1;
                idx++;
            }else
            {
                answer++;
                pos += (2 * w + 1);
            }
        }

        return answer;
    }
}