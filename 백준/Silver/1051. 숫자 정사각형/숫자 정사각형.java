//package BOJ.Section06.P1051;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P1051/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int startR = i;
                int startC = j;
                int len = 1;    // 정사각형 한변의 길이

                while(true){
                    int endR = startR + len;
                    int endC = startC + len;
                    len++;

                    if(endR >= N || endC >= M){
                        break;
                    }

                    int data = map[startR][startC];

                    if(map[startR][endC] != data){
                        continue;
                    }
                    if(map[endR][startC] != data){
                        continue;
                    }
                    if(map[endR][endC] != data){
                        continue;
                    }

                    ans = (int) Math.max(ans, Math.pow(endR - startR + 1, 2));
                }
            }
        }

        System.out.println(ans);
    }

}
