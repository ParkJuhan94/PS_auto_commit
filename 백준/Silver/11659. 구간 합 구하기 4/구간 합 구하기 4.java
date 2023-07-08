//package BOJ.Section05.P11659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P11659/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(sum[e] - sum[s - 1]);
        }
    }

}