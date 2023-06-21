//package DAY02.P1806;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String Args[]) throws IOException {
      //  System.setIn(new FileInputStream("src/DAY02/P1806/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1]; // out index 방지 곱일때는 마지막 원소 1로 만들어야함

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = Integer.MAX_VALUE; // 부분합의 최소 길이 저장
        int low = 0; // start 인덱스
        int high = 0; // end 인덱스
        int sum = arr[0]; // 합계 계산

        while(true){
            if(sum < S){
                sum += arr[++high];
            }else if(sum >= S){
                length = Math.min(high - low + 1, length);
                sum -= arr[low++];
            }

            if(high == N){
                break;
            }
        }

        if(length == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(length);
        }

    }
}
