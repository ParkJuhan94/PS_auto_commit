//package WEEK000.P15656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;
    static int[] arr;
    static int[] selected;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK000/P15656/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        ch = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int count){
        if(count == M){
            for(int num : selected){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            selected[count] = arr[i];
            dfs(count + 1);
        }
    }

}