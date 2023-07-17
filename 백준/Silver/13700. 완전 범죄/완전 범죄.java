//package BOJ.Section05.P13700;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section05/P13700/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int police[] = new int[N + 1];

        if(K != 0){
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < K; i++){
            police[Integer.parseInt(st.nextToken())] = 1;
        }

        int dist[] = new int[N + 1];
        for (int i = 1; i <= N; i++){
            dist[i] = -1;
        }
        dist[S] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int back = cur - B;
            int front = cur + F;

            if (cur == D) {
                System.out.println(dist[cur]);
                return;
            }

            // 범위 안이면서, 경찰서가 아니면서, 처음 가는 위치라면
            if (back >= 1 && police[back] == 0 && dist[back] == -1) {
                dist[back] = dist[cur] + 1;
                q.add(back);
                //System.out.println(cur + " 에서 " + back + " 로 왼쪽으로 이동");
            }

            if (front <= N && police[front] == 0 && dist[front] == -1) {
                dist[front] = dist[cur] + 1;
                q.add(front);
                //System.out.println(cur + " 에서 " + front + " 로 오른쪽으로 이동");
            }
        }

        System.out.println("BUG FOUND");
    }
}