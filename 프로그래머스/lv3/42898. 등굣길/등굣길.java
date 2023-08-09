import java.util.Arrays;

class Solution {
    int n;
    int m;
    int[][] map;
    int[][] ch;
    int MOD = 1_000_000_007;
    int[] dr = {1, 0};
    int[] dc = {0, 1};

    public int solution(int m, int n, int[][] puddles) {
        this.n = n;
        this.m = m;
        map = new int[101][101];
        ch = new int[101][101];
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], -1);
        }
        for(int i = 0; i < puddles.length; i++){
            int[] puddle = puddles[i];
            ch[puddle[1] - 1][puddle[0] - 1] = 1; // 물
        }

        int ans = dfs(0, 0) % MOD;

    //    printMap();

        return ans;
    }

    int dfs(int r, int c){

        if(r == n - 1 && c == m - 1){   // 도착지
            return map[r][c] = 1;
        }

        if(map[r][c] != -1){    // 방문했었다면 경로단축
            return map[r][c];
        }else{  // 처음 방문하면
            map[r][c] = 0;

            for(int i = 0; i < 2; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < n && 0 <= nc && nc < m && ch[nr][nc] == 0){
                    map[r][c] += dfs(nr, nc) % MOD;
                }
            }
        }

        return map[r][c] % MOD;
    }

    void printMap(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}