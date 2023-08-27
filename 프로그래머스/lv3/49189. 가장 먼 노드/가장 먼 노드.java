//package Programmers.Level_3.가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    ArrayList<Integer>[] adj;
    int[] ch;   // 방문여부
    int[] dist; // 최소거리
    int n;
    int answer = 1;

    public int solution(int n, int[][] edge) {
        this.n = n;
        dist = new int[n + 1];
        ch = new int[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];

            adj[s].add(e);
            adj[e].add(s);
        }

        ch[1] = 1;

        bfs();

        int max = -1;
        for(int i = 1; i <= n; i++){
            if(dist[i] > max){
                max = dist[i];
                answer = 1;
            }else if(dist[i] == max){
                answer++;
            }
        }

        return answer;
    }

    void bfs() {
        Queue<Integer> q = new LinkedList();
        q.add(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i < adj[cur].size(); i++){
                int next = adj[cur].get(i);

                if(ch[next] == 0){
                    ch[next] = 1;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}