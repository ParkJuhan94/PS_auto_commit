//package Practice.P2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map = new int[27][27];
    static int[][] ch = new int[27][27];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int count = 0; //  단지 숫자
    static ArrayList<Integer> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/Practice/P2667/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= N; i++){
            String input = br.readLine();
            for(int j = 1 ; j <= N; j++){
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(ch[i][j] == 0 && map[i][j] == 1){
                    // 단지 시작할 때 count 를 0으로 초기화
                    // 단지 끝날 때 count 를 배열에 추가해주기
                    count = 0;
                    ch[i][j] = 1;
                    dfs(i,j);
                    homes.add(count);
                }
            }
        }
        Collections.sort(homes);

        System.out.println(homes.size());
        for(int home : homes){
            System.out.println(home);
        }
    }

    static void dfs(int r, int c) {
        count++;

        for (int i = 0; i < 4; i++) {
            int tx = r + dx[i];
            int ty = c + dy[i];

            if (1 <= tx && tx <= N && 1 <= ty && ty <= N & ch[tx][ty] == 0
                    && map[tx][ty] == 1) {
                ch[tx][ty] = 1;
                dfs(tx, ty);
            }
        }
    }
}
