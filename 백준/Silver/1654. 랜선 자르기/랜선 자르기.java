//package TEST.P1654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/TEST/P1654/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        long max = 0;

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        // 반드시 max에서 +1 값이어야 한다.
        max++;

        long s = 0;
        long e = max;
        long mid = 0;

        /*
        이분 탐색에서는 크게 두 가지 방식이 존재한다.
        바로 Upper Bound(상한)와 Lower Bound(하한)이다.

        상한은 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환한다.
        하한은 찾고자 하는 특정 값 이상인 '첫 위치'를 반환한다.
         */
        // mid 는 자르는 단위 길이
        //  Upper Bound(상한)
        while(s < e){
            mid = (s + e) / 2;
            long sum = 0;    // sum은 잘라진 갯수

            for(int i = 0; i < K; i++){
                sum += arr[i] / mid;
            }

            if(sum < N){    // 미만 : 만족 안 했을 때
                e = mid;
            } else {        // 이상 : 만족 했을 때
                s = mid + 1;
            }
        }

        System.out.println(s-1);    // upper bound 니까 -1
    }
}