//package BOJ.Section04.P11725;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int parent;
    ArrayList<Integer> child = new ArrayList<>();
}

public class Main {
    static int N, M;
    static Node[] tree;
    static ArrayList<Integer>[] adj;
    static int[] ch;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section04/P11725/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node[N + 1];
        adj = new ArrayList[N + 1];
        ch = new int[N + 1];    // 방문한 노드는 체크 처리
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++){
            tree[i] = new Node();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        ch[1] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i < adj[cur].size(); i++){
                int adjNode = adj[cur].get(i);

                if(ch[adjNode] == 0){
                    tree[cur].child.add(adjNode);
                    tree[adjNode].parent = cur;

                    q.add(adjNode);
                    ch[cur] = 1;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(tree[i].parent);
        }
    }

}