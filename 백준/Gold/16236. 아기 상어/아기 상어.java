//package BOJ.Section04.P16236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static Shark shark;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P16236/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ch = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            if(!findFish()){
                break;
            }
            //print();
        }

        System.out.println(ans);
    }

    // 먹을 물고기 찾고 이동까지
    // 최대한 움직였을 때 먹은 물고기가 있는지 반환
    static boolean findFish(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(shark.r, shark.c, 0));
        ch[shark.r][shark.c] = 1;
        ch = new int[N][N];
        int minTime = Integer.MAX_VALUE;
        int minR = N;
        int minC = N;
        Point cand = null;
        int flag = 0;

        while(!q.isEmpty()){
            Point cur = q.poll();

            // 먹을 목록에 넣기
            if(map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < shark.size){
                // 우선순위 직접 만들기
                if(cur.time <= minTime){
                    minTime = cur.time;

                    if(cur.r < minR) {
                        minR = cur.r;
                        minC = cur.c;
                        cand = cur;
                    }
                    else if(cur.r == minR) {
                        if (cur.c < minC) {
                            minC = cur.c;
                            cand = cur;
                        }
                    }
                }

                flag = 1;
            }

            // 지나갈 경로 추가
            if(flag == 0){
                for(int i = 0; i < 4; i++){
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    // 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
                    if(0 <= nr && nr < N && 0 <= nc && nc < N){
                        if(map[nr][nc] <= shark.size && ch[nr][nc] == 0){
                            q.add(new Point(nr, nc, cur.time + 1));
                            ch[nr][nc] = 1;
                        }
                    }
                }
            }
        }

        // 먹을 수 있는 물고기가 없다면
        if(cand == null){
            return false;
        }

        shark.eat(cand);
        ans += cand.time;
        return true;
    }

    static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ans);
        System.out.println();
    }

    static class Point{
        int r;
        int c;
        int time;   // 아기상어가 해당 지점까지 오는데 걸린 시간

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static class Shark {
        int r;
        int c;
        int size = 2;
        int eaten = 0;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }

        // 상어가 물고기를 먹을 때
        void eat(Point cand) {
            map[cand.r][cand.c] = 0;
            shark.r = cand.r;
            shark.c = cand.c;
            eaten++;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }
    }
}

