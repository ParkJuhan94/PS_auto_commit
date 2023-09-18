// package Programmers.Level_3.합승택시요금;

class Solution {
    int N, s, a, b;
    int[][] dist;
    final int INF = 30_000_000;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.N = n;
        this.s = s;
        this.a = a;
        this.b = b;

        // 플로이드 거리 배열 초기화
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {   // 자기 자신으로 가는 비용은 최소
                    dist[i][j] = 0;
                }else{      // 자기 자신으로 가는 경우를 제외하고는 매우 큰 값
                    dist[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];

            dist[c][d] = f;
            dist[d][c] = f;
        }

        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {
            // 노드 i에서 j로 가는데, k를 거쳐서 가는 경우
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) 
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <= N; i++){
            rideAlong(i);
        }

        return answer;
    }

    void rideAlong(int v) {
        int sum = 0;

        // 합승 요금
        sum += dist[s][v];

        // 각자의 요금
        sum += dist[v][a];
        sum += dist[v][b];

        answer = Math.min(answer, sum);
    }
}
