//package WEEK00.P9205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static ArrayList<Point> arr;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P9205/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            arr = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            adj = new ArrayList[N + 2];

            // 위치 저장
            for(int i = 0; i < N + 2; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                arr.add(new Point(s, e));
            }

            // 인접리스트 구현
            for(int i = 0; i < N + 2; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < N + 2; i++){
                for(int j = i + 1; j < N + 2; j++){
                    int dist = Math.abs(arr.get(i).r - arr.get(j).r) +
                            Math.abs(arr.get(i).c - arr.get(j).c);
                    if(dist <= 1000){
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }

            bfs();
        }

        System.out.println(sb);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[arr.size()];

        q.add(0);
        ch[0] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == N + 1){
                sb.append("happy" + "\n");
                return;
            }

            for(int i = 0; i < adj[cur].size(); i++){
                int next = adj[cur].get(i);
                if(ch[next] == 0){
                    q.add(next);
                    ch[next] = 1;
                }
            }
        }

        sb.append("sad" + "\n");
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