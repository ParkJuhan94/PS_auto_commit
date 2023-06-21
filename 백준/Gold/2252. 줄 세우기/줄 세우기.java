

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
       // System.setIn(new FileInputStream("src/DAY06/P2252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] in = new int[N+1];    //각 정점의 in degree 저장

        //  가중치가 없는 비순환 방향 그래프 -> 인접 리스트 활용
        ArrayList<Integer>[] adj = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList();
        }

        //  단방향 연결 설정
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            in[to]++;   //  후행 정점의 in degree 를 1 증가
        }

        //  위상 정렬!!
        Queue<Integer> q = new LinkedList();
        //  초기 : 선행 정점을 가지지 않는 정점을 큐에 삽입
        for(int i = 1; i < N+1; i++) {
            if(in[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll(); //  1. 큐에서 정점 추출
            sb.append(now).append(" "); //  정점 출력

            //  2. 해당 정점과 인접한 모든 정점을 순회
            for(int next: adj[now]) {
                in[next]--; //  2-1. in degree 감소

                //  2-2. 선행 정점을 가지지 않는 정점을 큐에 삽입
                if(in[next] == 0) q.add(next);
            }
        }
        System.out.println(sb);
    }
}