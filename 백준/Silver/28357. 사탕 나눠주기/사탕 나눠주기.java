//package BOJ.Section06.P28357;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long K;
    static long[] scores;
    static long standard = 0;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section06/P28357/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        scores = new long[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            scores[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(scores);
        max = scores[scores.length - 1];

        search();

        System.out.println(standard);
    }

    static void search(){
        long s = 0;
        long e = max;

        while(s <= e){
            long mid = (s + e) / 2;

            if(numCandy(mid) > K){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        standard = s;
    }

    static long numCandy(long standard){
        long res = 0;
        for(int i = 0; i < N; i++){
            if(scores[i] >= standard){
                res += (scores[i] - standard);
            }
        }
        return res;
    }
}