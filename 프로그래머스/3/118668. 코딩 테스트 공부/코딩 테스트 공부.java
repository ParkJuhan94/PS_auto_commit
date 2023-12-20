// package Programmers.Level_3_2.코딩테스트공부;

import java.util.Arrays;

class Solution {

    static final int INF = Integer.MAX_VALUE;
    int maxAlp;
    int maxCop;

    public int solution(int alp, int cop, int[][] problems) {
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        // dp[alp][cop] = (alp,cop) 위치까지 도달하는데 걸리는 최단 시간
        int[][] dp = new int[maxAlp + 1][maxCop + 1];

        alp = Math.min(alp, maxAlp); // alp가 이미 maxAlp보다 더 클 수 있음 -> 오버플로우 발생 방지
        cop = Math.min(cop, maxCop); // cop도 동일

        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }

        dp[alp][cop] = 0; // 시작 위치

        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                // 공부하는 경우
                if(i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if(j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                // 문제 푸는 경우
                for (int[] problem : problems) {
                    if(problem[0] <= i && problem[1] <= j) { // 풀 수 있는 경우
                        int nextAlp = Math.min(maxAlp, i + problem[2]); // maxAlp 범위를 초과하는 경우
                        int nextCop = Math.min(maxCop, j + problem[3]); // maxCop 범위를 초과하는 경우
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        // 시간 복잡도는 O(목표 알고력 * 목표 코딩력 * (problems 배열의 길이))

        return dp[maxAlp][maxCop];
    }
}
