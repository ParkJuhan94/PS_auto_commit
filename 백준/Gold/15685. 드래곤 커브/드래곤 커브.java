//package BOJ.Section07.P15685;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int SIZE = 101;
    static int answer = 0;
    // 90도 회전 : 우하좌상
    // xy반대   : 우상좌하
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] map;
    static ArrayList<Integer> dList;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section07/P15685/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new boolean[SIZE][SIZE];
        N = Integer.parseInt(st.nextToken());

        int r, c, d, g; // x = r, y = c
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            // x, y 반대로 입력받기
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            dList = new ArrayList<>();
            dList.add(d);
            makeCurve(g);
            drawCurve(r, c);
        }

        countAnswer();
        System.out.println(answer);
    }

    static void makeCurve(int gen){
        for(int g = 0; g < gen; g++){
            int size = dList.size();

            for(int i = 1; i <= size; i++){
                dList.add((dList.get(size - i) + 1) % 4);
            }
        }
    }

    static void drawCurve(int r, int c){
        int nr = r;
        int nc = c;

        map[r][c] = true;
        int size = dList.size();

        for(int i = 0; i < size; i++){
            int d = dList.get(i);

            nr += dr[d];
            nc += dc[d];
            map[nr][nc] = true;
        }
    }

    static void countAnswer() {
        for(int i = 0; i < SIZE - 1; i++){
            for(int j = 0; j < SIZE - 1; j++){
                if(map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]){
                    answer++;
                }
            }
        }
    }

}