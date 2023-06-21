//package WEEK0.P2563;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK0/P2563/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[100][100];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j <= x + 9; j++){
                for(int k = y; k <= y + 9; k++){
                    map[j][k] = true;
                }
            }
        }

        int ans = 0;
        for(int j = 0; j < 100; j++){
            for(int k = 0; k < 100; k++){
                if(map[j][k] == true){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}