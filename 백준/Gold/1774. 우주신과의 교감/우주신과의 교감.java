//package BOJ.Section05.P1774;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section05/P1774/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Point[] points = new Point[V + 1];
        List<Edge> edges = new ArrayList<>();
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            points[i] = new Point(r, c);
        }

        // 사전에 연결된 간선을 미리 합집합 연산
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);
        }

        // 간선 만들기
        for(int i = 1; i <= V; i++){
            for(int j = i + 1; j <= V; j++){
                double distance = distance(points[i], points[j]);
                edges.add(new Edge(i, j, distance));
            }
        }

        // 간선을 가중치 기준으로 오름차순 정렬
        Collections.sort(edges);

//        for(Edge edge : edges){
//            System.out.println(edge);
//        }

        double answer = 0;

        // 크루스칼 알고리즘 수행
        for (Edge edge : edges) {
            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.weight;
            }
        }

        System.out.printf("%.2f", answer);
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

    static double distance(Point a, Point b){
        long powR = (long) Math.pow(Math.abs(a.r - b.r), 2);
        long powC = (long) Math.pow(Math.abs(a.c - b.c), 2);
        return Math.sqrt(powR + powC);
    }
}

class Point{
    long r;
    long c;

    public Point(long r, long c) {
        this.r = r;
        this.c = c;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        if(this.weight > other.weight){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}