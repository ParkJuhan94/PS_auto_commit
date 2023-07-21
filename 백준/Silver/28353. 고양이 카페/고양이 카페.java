//package BOJ.Section06.P28353;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P28353/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] cats = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);
        int p1 = 0;
        int p2 = cats.length - 1;
        int ans = 0;

        while(p1 < p2){
            if(cats[p1] + cats[p2] <= K){
                p1++;
                p2--;
                ans++;
            }else{
                p2--;
            }
        }

        System.out.println(ans);
    }

}