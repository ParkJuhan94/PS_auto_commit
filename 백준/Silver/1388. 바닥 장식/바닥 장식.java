//package BOJ.Section04.P1388;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P1388/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input.charAt(j);
            }
        }

        System.out.println(search());
    }

    static int search(){
        int res = 0;

        // 가로
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == '-'){
                    //System.out.println("가로" + i + ", " + j);
                    int nextStart = j;
                    while(nextStart + 1 < M && map[i][nextStart + 1] == '-'){
                        nextStart++;
                    }

                    // 다음 그룹으로 건너뛰기
                    j = nextStart;
                    res++;
                }
            }
        }

        // 세로 : 가로랑 y = x 축 대칭 (까다로움)
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[j][i] == '|'){
                    //System.out.println("세로" + i + ", " + j);
                    int nextStart = j;
                    while(nextStart + 1 < N && map[nextStart + 1][i] == '|'){
                        nextStart++;
                    }

                    // 다음 그룹으로 건너뛰기
                    j = nextStart;
                    res++;
                }
            }
        }

        return res;
    }

}