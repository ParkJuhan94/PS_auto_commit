//package BOJ.Section06.P1058;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int cnt = 0;
    static int ans = 0;
    static int[] ch;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P1058/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                char c = input.charAt(j);
                if(i < j){
                    if(c == 'Y'){
                        adj[i + 1].add(j + 1);
                        adj[j + 1].add(i + 1);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            set = new HashSet<>();
            dfs(0, i, i);
            ans = Math.max(ans, set.size());
        }

        System.out.println(ans);
    }

    static void dfs(int depth, int idx, int start) {
        if(depth == 2){
            return;
        }

        for(int i = 0; i < adj[idx].size(); i++){
            int next = adj[idx].get(i);

            if(next != start){
                dfs(depth + 1, next, start);
                set.add(next);
            }
        }
    }
}