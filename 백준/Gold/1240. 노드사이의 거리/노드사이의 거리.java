//package BOJ.Section05.P1240;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] adj;
    static Queue<Node> q;
    static int[] ch;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P1240/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        ch = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향으로 !!
            adj[s].add(new Node(e, w));
            adj[e].add(new Node(s, w));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(bfs(s, e));
        }

    }

    static int bfs(int s, int e){
        ch = new int[N + 1];
        q = new LinkedList<>();
        q.add(new Node(s, 0));
        ch[s] = 1;

        int dist = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.idx == e){
                dist = cur.dist;
                break;
            }

            for(int i = 0; i < adj[cur.idx].size(); i++){
                Node nextNode = adj[cur.idx].get(i);

                if(ch[nextNode.idx] == 0){
                    // 현재까지의 거리에다가 + 다음까지의 거리
                    q.add(new Node(nextNode.idx, cur.dist + nextNode.dist));
                    ch[nextNode.idx] = 1;
                }
            }
        }

        return dist;
    }
}

class Node{
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}