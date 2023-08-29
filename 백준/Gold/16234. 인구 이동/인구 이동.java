//package BOJ.Section07.P16234;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int ans = 0;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point> unitedList;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section07/P16234/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        ch = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search();

        System.out.println(ans);
    }

    static void search() {

        //print();

        while(true){
            boolean isUnited = false;
            ch = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(ch[i][j] == 0){
                        q = new LinkedList<>();
                        unitedList = new ArrayList<>();

                        q.add(new Point(i, j));
                        unitedList.add(new Point(i, j));
                        ch[i][j] = 1;
                        int sum = map[i][j];

                        while(!q.isEmpty()){
                            Point cur = q.poll();

                            for(int k = 0; k < 4; k++){
                                int nr = cur.r + dr[k];
                                int nc = cur.c + dc[k];

                                if(0 <= nr && nr < N && 0 <= nc && nc < N && ch[nr][nc] == 0){
                                    int diff = Math.abs(map[cur.r][cur.c] - map[nr][nc]);

                                    if(L <= diff && diff <= R){
                                        ch[nr][nc] = 1;
                                        q.add(new Point(nr, nc));
                                        sum += map[nr][nc];
                                        unitedList.add(new Point(nr, nc));
                                        isUnited = true;
                                    }
                                }
                            }
                        }

                        if(unitedList.size() != 1){
                            int mod = sum / unitedList.size();

                            for(Point p : unitedList){
                                map[p.r][p.c] = mod;
                            }
                        }
                    }
                }
            }

            if(!isUnited){
                break;
            }else{
                //print();
                ans++;
            }
        }

    }

    static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
