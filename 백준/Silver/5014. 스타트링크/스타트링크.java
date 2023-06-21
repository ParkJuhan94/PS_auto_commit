//package WEEK0.P5014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK0/P5014/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[F + U + 5];
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        dist[S] = 1;    // 시작부터 1 이니까 결과에서 1 빼주자

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == G){
                System.out.println(dist[cur] - 1);
                return;
            }

            if(cur + U <= F && dist[cur + U] == 0){
                q.add(cur + U);
                dist[cur + U] = dist[cur] + 1;
            }

            if(cur - D >= 1 && dist[cur - D] == 0){
                q.add(cur - D);
                dist[cur - D] = dist[cur] + 1;
            }
        }

        // while 에서 G 층을 못 가면
        System.out.println("use the stairs");
    }

}