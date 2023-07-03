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
        M = Integer.parseInt(st.nextToken());

        for(int i = N; i <= M; i++){
            int flag = 0;
            for(int j = 2; j * j <= i ; j++){
                if(i % j == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0 && i != 1){
                System.out.println(i);
            }
        }


    }

}