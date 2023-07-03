//package BOJ.Section04.P1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section04/P1929/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        N = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[1010];
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= 1000; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isPrime[arr[i]]) {
                cnt++;               
            }
        }
        System.out.print(cnt);
    }

}