//package WEEK00.P12851;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P12851/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        int[] map = new int[100001];
        int[] ch = new int[100001];
        q.add(new Point(N, 0));
        ch[N] = 1;
        int time = 0;
        int cnt = 0;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == K){
                if(cnt == 0){
                    time = cur.y;   // 가장 빠른 시간 저장
                }
                if(time == cur.y){  // 도착한 경로의 시간이, 가장 빠른 시간과 같다면
                    cnt++;
                }
                continue;
            }

            int[] arr = {cur.x - 1, cur.x + 1, cur.x * 2};

            for(int i = 0; i < 3; i++){
                int next = arr[i];
                if(next < 0 || next > 100000){
                    continue;
                }
                if(ch[next] == 0 || ch[next] == cur.y + 1){
                    ch[next] = cur.y + 1;
                    q.add(new Point(next, cur.y + 1));
                }
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }
}