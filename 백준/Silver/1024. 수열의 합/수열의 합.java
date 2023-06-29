//package BOJ.Section04.P1024;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P1024/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int num = -1;
        int count = 0;

        for(int i = M; i <= 100; i++){
            if(sum(i - 1) > N){
                break;
            }

            if((N - sum(i - 1)) % i == 0){
                num = (N - sum(i - 1)) / i;
                count = i;
                break;
            }
        }

        if(num == -1){
            System.out.println(-1);
        }else{
            for(int i = 0; i < count; i++){
                System.out.print(num + i + " ");
            }
        }
    }

    // 0부터 n 까지의 합을 반환
    static int sum(int n){
        int res = 0;
        for(int i = 0; i <= n; i++){
            res += i;
        }
        return res;
    }

}