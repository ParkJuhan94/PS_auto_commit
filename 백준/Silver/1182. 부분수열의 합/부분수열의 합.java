//package BOJ.Section06.P1182;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int ans = 0;
    static int[] ch;
    static int[] nums;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P1182/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        ch = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        // 합이 0인 경우는 공집합을 포함해버리니까!
        if (S == 0) ans--;

        System.out.println(ans);
    }

    static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == S){
                ans++;
            }
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + nums[depth]);
    }
}