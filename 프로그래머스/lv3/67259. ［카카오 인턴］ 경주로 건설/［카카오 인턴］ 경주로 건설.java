//package Programmers.Level_3.경주로건설;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int N;  // N = 25
    int[][] board;
    int[][] dist;
    boolean[][][] visited;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        this.N = board.length;
        this.board = board;
        visited = new boolean[N][N][4];
        dist = new int[N][N];

        bfs();

        //printDist();

//        if(N == 5){
//            System.out.println(dist[3][3]);
//            System.out.println(dist[4][3]);
//        }

        return answer;
    }

    void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, -1, 0));
        for(int i = 0; i < 4; i++){
            visited[0][0][i] = true;
        }

        while(!q.isEmpty())
        {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int dir = cur.dir;
            int cost = cur.cost;

            if(r == N - 1 && c == N - 1){
                answer = Math.min(answer, cost);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 0)
                {
                    int counterDir = (i + 2) % 4;
                    int nextCost = 0;
                    if(dir == i || dir == -1){  // 처음은 무조건 직선
                        nextCost = cost + 100;
                    }else{
                        nextCost = cost + 600;
                    }

                    if(!visited[nr][nc][counterDir] || nextCost <= dist[nr][nc]){
                        visited[nr][nc][counterDir] = true;
                        dist[nr][nc] = nextCost;
                        q.add(new Point(nr, nc, i, nextCost));
                    }
                }
            }
        }
    }

    void printDist() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point{
    int r;
    int c;
    int dir;
    int cost;

    public Point(int r, int c, int dir, int cost) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}