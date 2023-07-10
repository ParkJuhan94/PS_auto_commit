//package BOJ.Section05.P1197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int result = 0;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("src/BOJ/Section05/P1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        // 유니온파인드 초기화
        for(int i = 0; i < n + 1; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        // 시작점과 종료점의 최상위 노드를 find 로 찾아서 겹치면 사이클!
        // -> continue
        // 사이클이 아니면 union 으로 연결하고 가중치 v로 더해준다
        for(int i = 0; i < m; i++) {
            edge tmp = pq.poll();

            int a = find(tmp.s);
            int b = find(tmp.e);

            if(a == b) continue;
            union(a, b);
            result += tmp.v;
        }

        System.out.println(result);
    }

    // 유니온 파인드
    public static int find(int a) {
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) {
            parent[aRoot] = b;
        }
    }
}

// 우선순위 큐에 넣기위해 정렬기준
class edge implements Comparable<edge>{
    int s;
    int e;
    int v;

    public edge(int s,int e,int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(edge arg0) {
        // TODO Auto-generated method stub
        return arg0.v >= this.v ? -1:1;
    }
}