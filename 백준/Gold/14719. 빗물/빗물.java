//package WEEK00.P14719;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK00/P14719/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int[] block = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(j < block[i]){
                    map[N - j - 1][i] = 1;
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        int flag = 0;
        int prev = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            flag = 0;
            prev = 0;

            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    if(flag == 1){  // 한 번이라도 블록이 나왔다면
                        sum += (j - prev - 1);
                        prev = j;
                    }else{          // 블록 처음 나온거면 flag 체크
                        flag = 1;
                        prev = j;
                    }
                }
            }
        }

        System.out.println(sum);
    }

}
