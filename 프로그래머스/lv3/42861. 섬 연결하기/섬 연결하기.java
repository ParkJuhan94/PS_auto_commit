import java.util.Arrays;

class Solution {
    int n;
    int[][] costs_;
    static int[] parent;
    int answer = 0;
    
    public int solution(int n, int[][] costs) {
        this.n = n;
        costs_ = costs;

        // 부모 노드 초기화
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        Arrays.sort(costs_, (o1, o2) -> {
            return o1[2] - o2[2];   // 3번째 숫자 기준 오름차순 정렬
        });

        int cnt = 0;    // 이어진 섬 갯수
        
        for(int i = 0; i < costs_.length; i++){
            int s = costs[i][0];
            int e = costs[i][1];
            int w = costs[i][2];

            if(union(s, e)){
                answer += w;
                cnt++;
                
                if(cnt == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }
    
    // union 연산
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        // 더 작은 번호의 노드를 부모로 해야한다면
        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    // find 연산
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}