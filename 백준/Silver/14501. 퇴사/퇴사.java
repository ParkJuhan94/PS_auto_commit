//package BOJ.Section06.P14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] times;
    static int[] pays;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P14501/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        times = new int[N];
        pays = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    static void dfs(int depth, int pay) {
        if(depth >= N){
            ans = Math.max(ans, pay);
            return;
        }

        // 1. 해당 상담을 안 할 때
        dfs(depth + 1, pay);
        // 1. 해당 상담을 할 때
        if(depth + times[depth] <= N) {
            dfs(depth + times[depth], pay + pays[depth]);
        }
    }

}