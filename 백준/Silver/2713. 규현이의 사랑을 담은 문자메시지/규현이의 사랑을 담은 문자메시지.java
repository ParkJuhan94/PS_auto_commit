//package BOJ.Section05.P2713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] ch;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P2713/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            char[][] map = new char[N][M];
            ch = new int[N][M];

            int idx = 0;
            int cnt = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == ' '){
                    cnt++;
                    if(cnt == 2){
                        idx = i + 1;
                        break;
                    }
                }
            }

            String msg = input.substring(idx);
            int[] msgArr = new int[msg.length()];

            for(int i = 0; i < msg.length(); i++){
                if(msg.charAt(i) != ' '){
                    msgArr[i] = msg.charAt(i) - 'A' + 1;
                }
            }

            StringBuilder outputSum = new StringBuilder();

            for (int num : msgArr) {
                StringBuilder output = new StringBuilder();

                String num2Str = Integer.toString(num, 2);
                int len = num2Str.length();

                for (int j = 0; j < 5 - len; j++) {
                    output.append("0");
                }
                output.append(num2Str);
                outputSum.append(output);
            }

            int direct = 0;
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0, 0));
            if (outputSum.length() > 0) {
                map[0][0] = outputSum.charAt(0);
            }else{
                map[0][0] = '0';
            }
            ch[0][0] = 1;
            int outputSumIdx = 1;

            while(!q.isEmpty()){
                Point cur = q.poll();
                int nr = cur.r + dr[direct % 4];
                int nc = cur.c + dc[direct % 4];

                if(0 <= nr && nr < N && 0 <= nc && nc < M && ch[nr][nc] == 0){
                    if(outputSumIdx >= outputSum.length()){
                        map[nr][nc] = '0';
                    }else{
                        map[nr][nc] = outputSum.charAt(outputSumIdx++);
                    }
                    ch[nr][nc] = 1;
                    q.add(new Point(nr, nc));
                }else{
                    if(!isFull()){
                        q.add(cur);
                        direct++;
                    }
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    static boolean isFull(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(ch[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}