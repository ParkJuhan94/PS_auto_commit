//package WEEK0.P90;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK0/P90/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int sum = 0;
        int ans = 64;

        for(int a = 0; a <= N - 8; a++){
            for(int b = 0; b <= M - 8; b++){
                sum = 0;
                for(int i = a; i < a + 8; i++){
                    for(int j = b; j < b+ 8; j++){
                        if((i + j) % 2 == 0){
                            if(map[i][j] == 'W'){
                                sum++;
                            }
                        }else{
                            if(map[i][j] == 'B'){
                                sum++;
                            }
                        }
                    }
                }
                ans = Math.min(ans, sum);
                ans = Math.min(ans, 64 - sum);
            }
        }



        System.out.println(ans);
    }

}