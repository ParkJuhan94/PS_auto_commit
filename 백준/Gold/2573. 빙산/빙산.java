//package WEEK00.P2573;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK00/P2573/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            int status = search();
            if(status == -1){
                System.out.println(0);
                break;
            }

            ch = new int[N][M];
            q.clear();
            int flag = 0;

            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    if(map[r][c] > 0){
                        q.add(new Point(r, c));
                        ch[r][c] = 1;
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    break;
                }
            }

            while(!q.isEmpty()){
                Point cur = q.poll();

                for(int k = 0; k < 4; k++){
                    int nr = cur.r + dr[k];
                    int nc = cur.c + dc[k];

                    if(0 <= nr && nr < N && 0 <= nc && nc < M
                            && map[nr][nc] != 0 && ch[nr][nc] == 0){
                        q.add(new Point(nr, nc));
                        ch[nr][nc] = 1;
                    }
                }
            }

            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    if(map[r][c] > 0 && ch[r][c] == 0){
                        System.out.println(ans);
                        return;
                    }
                }
            }
        }
    }

    static int search(){
        q.clear();

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] == 0){
                    for(int k = 0; k < 4; k++){
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0){
                            q.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }

        if(q.isEmpty()){
            return -1;
        }

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(map[cur.r][cur.c] >= 1){
                map[cur.r][cur.c]--;
            }
        }

        ans++;

        return 0;
    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}