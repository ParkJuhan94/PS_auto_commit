//package BOJ.Section06.P13305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] gasStation;
    static int[] dist;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P13305/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        gasStation = new int[N];
        dist = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            gasStation[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            long distSum = 0;
            int price = gasStation[i];

            for(int j = i + 1; j < N; j++){
                if(gasStation[j] > gasStation[i]){
                    distSum += dist[j - 1];
                    i = j;
                }else{
                    distSum += dist[j - 1];
                    break;
                }
            }
            ans += price * distSum;
        }

        System.out.println(ans);
    }

}