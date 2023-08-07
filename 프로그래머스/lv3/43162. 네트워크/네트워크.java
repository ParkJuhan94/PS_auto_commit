import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] adj;
    int[] ch;
    int n;
    int answer;

    public int solution(int n, int[][] computers) {
        this.n = n;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        ch = new int[n];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    adj[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(ch[i] == 0){
                answer++;
            }
            ch[i] = 1;
            dfs(i);
        }

        return answer;
    }

    void dfs(int idx) 
    {
        for(int i = 0; i < adj[idx].size(); i++){
            int next = adj[idx].get(i);
            
            if(ch[next] == 0){
                ch[next] = 1;
                dfs(next);
            }
        }

    }
}