//package WEEK0.P2644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] checked;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/WEEK0/P2644/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        checked = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 인접 리스트 구현
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            adj[parent].add(child);
            adj[child].add(parent);
        }

        checked[start] = true;
        dfs(start, end, 0);

        System.out.println(ans);
    }

    static void dfs(int start, int end, int cnt){
        if(start == end) {
            ans = cnt;
            return;
        }

        checked[start] = true;
        for(int i = 0; i < adj[start].size(); i++){
            int next = adj[start].get(i);
            if(!checked[next]){
                dfs(next, end, cnt + 1);
            }
        }
    }
}