//package WEEK06.P2447;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/WEEK06/P2447/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) map[i][j] = ' ';
        }

        setStar(N, 0, 0);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void setStar(int N, int y, int x) {
        if(N == 1) map[y][x] = '*';
        else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == 1 && j == 1);
                    else setStar(N/3, y + N/3*i, x + N/3*j);
                }
            }
        }
    }
}
