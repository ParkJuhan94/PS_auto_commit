//package Practice.P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] ch;
    static ArrayList<Integer> adj[];
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/DAY0/P/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        adj = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        ch[1] = 1;
        Q.add(1);
        int x;
        int ans = 0;
        while(!Q.isEmpty()){
            x = Q.poll();
            for(int i = 0 ; i < adj[x].size(); i++){
                if(ch[adj[x].get(i)] == 0){
                    ch[adj[x].get(i)] = 1;
                    Q.add(adj[x].get(i));
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
