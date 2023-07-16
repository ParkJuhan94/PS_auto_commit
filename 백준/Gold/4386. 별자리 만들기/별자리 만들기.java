//package BOJ.Section05.P4386;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P4386/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++){
            parent[i] = i;
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            double r = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            points.add(new Point(r, c));
        }

        // 간선 만들기
        for(int i = 0; i < V; i++){
            for(int j = i + 1; j < V; j++){
                double distance = distance(points.get(i), points.get(j));
                edges.add(new Edge(i, j, distance));
            }
        }

        // 간선을 가중치 기준으로 오름차순 정렬
        Collections.sort(edges);

        double answer = 0;

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
        double powR = Math.pow(Math.abs(a.r - b.r), 2);
        double powC = Math.pow(Math.abs(a.c - b.c), 2);
        return Math.sqrt(powR + powC);
    }
}

class Point{
    double r;
    double c;

    public Point(double r, double c) {
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
        return (int) (this.weight - other.weight);
    }
}
