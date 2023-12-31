// package Programmers.Level_3.파괴되지않은건물;

// N, M = 1000
// K = 250,000
// O(K + N * M)
// 2차원배열 누적합

class Solution {
    public static int[][] sums;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        sums = new int[r + 1][c + 1];

        for(int[] s : skill){
            int type = s[0];
            if(type == 1){
                sums[s[1]][s[2]] -= s[5];
                sums[s[3] + 1][s[2]] += s[5];
                sums[s[1]][s[4] + 1] += s[5];
                sums[s[3] + 1][s[4] + 1] -= s[5];
            } else {
                sums[s[1]][s[2]] += s[5];
                sums[s[3] + 1][s[2]] -= s[5];
                sums[s[1]][s[4] + 1] -= s[5];
                sums[s[3] + 1][s[4] + 1] += s[5];
            }
        }


        // 왼 -> 오른
        for(int i=0;i<r+1;i++){
            for(int j=0;j<c;j++){
                sums[i][j+1] += sums[i][j];
            }
        }



        // 위 -> 아래
        for(int j=0;j<c+1;j++){
            for(int i=0;i<r;i++){
                sums[i+1][j] += sums[i][j];
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] + sums[i][j] > 0) answer++;
            }
        }

        return answer;
    }


}