//package BOJ.Section06.P18352;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P18352/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
        }

        bfs();

        int flag = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] == K){
                System.out.println(i);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println(-1);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        dist[X] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i < adj[cur].size(); i++)
            {
                int next = adj[cur].get(i);

                if(dist[next] == 0 && next != X){
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}