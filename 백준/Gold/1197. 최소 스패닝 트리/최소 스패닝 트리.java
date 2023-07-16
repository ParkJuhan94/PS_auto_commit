package BOJ.Section05.P1197;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/Section05/P1197/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        // 간선을 가중치 기준으로 오름차순 정렬
        Collections.sort(edges);

        int totalWeight = 0;

        for (Edge edge : edges) {
            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                totalWeight += edge.weight;
            }
        }

        System.out.println(totalWeight);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        // 더 작은 번호의 노드를 부모로 해야한다면
        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
