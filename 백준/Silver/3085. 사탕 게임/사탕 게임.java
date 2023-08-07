//package BOJ.Section06.P3085;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int ans = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P3085/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j);
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){

                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(0 <= nr && nr < N && 0 <= nc && nc < N){
                        if(map[r][c] != map[nr][nc]){
                            char[][] tempMap = cloneMap(map);
                            char tmpChar = tempMap[r][c];
                            tempMap[r][c] = tempMap[nr][nc];
                            tempMap[nr][nc] = tmpChar;

                            for(int rr = 0; rr < N; rr++){
                                int cnt = 1;
                                for(int cc = 0; cc < N - 1; cc++){
                                    if(tempMap[rr][cc] == tempMap[rr][cc + 1]){
                                        cnt++;
                                        ans = Math.max(ans, cnt);
                                    }else{
                                        ans = Math.max(ans, cnt);
                                        cnt = 1;
                                    }
                                }

                                cnt = 1;
                                for(int cc = 0; cc < N - 1; cc++){
                                    if(tempMap[cc][rr] == tempMap[cc + 1][rr]){
                                        cnt++;
                                        ans = Math.max(ans, cnt);
                                    }else{
                                        ans = Math.max(ans, cnt);
                                        cnt = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static char[][] cloneMap(char[][] map){
        char[][] res = new char[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                res[i][j] = map[i][j];
            }
        }

        return res;
    }

}