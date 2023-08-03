//package BOJ.Section06.P1368;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] waste;
    static int ans = 0;
    static ArrayList<Edge> adj;
    static int[] parents;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section06/P1368/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        waste = new int[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            waste[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }
        adj = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
            {
                int w = Integer.parseInt(st.nextToken());
                if(i == j) { // 우물을 파는 경우
                    // 가상의 노드 0번과 연결 (아무 노드랑도 연결되지 않게)
                    adj.add(new Edge(0, i, waste[i]));
                }else if(i < j) {
                    adj.add(new Edge(i, j, w));
                }
            }
        }

        Collections.sort(adj);

        // 크루스칼
        for (int i = 0; i < adj.size(); i++) {
            Edge cur = adj.get(i);
            int s = cur.s;
            int e = cur.e;

            if(find(s) != find(e))
            {
//                System.out.print("s = " + s);
//                System.out.print(", e = " + e);
//                System.out.println(", w = " + cur.w);

                union(s, e);
                ans += cur.w;
            }
        }

        System.out.println(ans);
    }

    static int find(int v) {
        if(parents[v] == v){
            return v;
        }else{
            return find(parents[v]);
        }
    }

    static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        // 일단 작은 번호를 부모 노드로 택한다는 가정이다.
        if(v1 < v2){
            parents[p2] = p1;
        }else{
            parents[p1] = p2;
        }
    }
}

class Edge implements Comparable<Edge>{
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}