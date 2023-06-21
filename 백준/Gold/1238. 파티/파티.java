import java.util.*;

class Edge implements Comparable<Edge> {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from].add(new Edge(to, cost));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.cost) {
                continue;
            }

            for (Edge next : graph[cur.to]) {
                int newDist = dist[cur.to] + next.cost;

                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Edge(next.to, newDist));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            int[] dist2 = new int[n + 1];
            Arrays.fill(dist2, INF);

            PriorityQueue<Edge> pq2 = new PriorityQueue<>();
            pq2.offer(new Edge(i, 0));
            dist2[i] = 0;

            while (!pq2.isEmpty()) {
                Edge cur = pq2.poll();

                if (dist2[cur.to] < cur.cost) {
                    continue;
                }

                for (Edge next : graph[cur.to]) {
                    int newDist = dist2[cur.to] + next.cost;

                    if (newDist < dist2[next.to]) {
                        dist2[next.to] = newDist;
                        pq2.offer(new Edge(next.to, newDist));
                    }
                }
            }

            ans = Math.max(ans, dist[i] + dist2[x]);
        }

        System.out.println(ans);
    }
}
