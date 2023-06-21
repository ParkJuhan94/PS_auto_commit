//package DAY02.P2003;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;

    public static void main(String Args[]) throws IOException {
      //  System.setIn(new FileInputStream("src/DAY02/P2003/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = arr[0], answer = 0;

        while(true){
            if(sum < M){
                sum += arr[++high];
            }else if(sum > M){
                sum -= arr[low++];
            }else if(sum == M){
                answer++;
                sum -= arr[low++];
            }

            if(high == N){
                break;
            }
        }

        System.out.println(answer);
    }
}
