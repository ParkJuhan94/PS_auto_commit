//package BOJ.Section04.P1275;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, S;
    static long[] tree;
    static int[] nums;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section04/P1275/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[2 * S];

        initBU();

        for(int i = 0 ; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // x~y는 당연히 x번째 부터 y번째가 맞다.
            // 하지만, 이 문제에서는 x > y인 경우 y번째 부터 x번째이다.
            if(x > y){
                System.out.println(query(1,S,1,y,x));
            }else{
                System.out.println(query(1,S,1,x,y));
            }

            update(1, S, 1, a, b - tree[S + a - 1]);
        }
    }

    static void initBU() {
        // leaf 노드 채우기
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부 노드 채우기
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // 구간 합 구하기
    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 구간합의 start, 구간합의 end)
    static long query(int left, int right, int node, int queryLeft, long queryRight) {
        // 구간합의 범위에 전혀 연관이 없는 경우
        if (left > queryRight || right < queryLeft) {
            return 0;
        }
        // 구간합의 범위에 현재 노드 범위 전체가 포함되는 경우 (쪼개다가 이까지 도달해야해)
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 구간합의 범위에 현재 노드 범위 일부가 포함되는 경우
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 변경할 data index, 변경할 값)
    static void update(int left, int right, int node, int target, long diff) {
        // 현재 노드의 범위에 변경할 data index 가 포함되지 않는 경우
        if (left > target || right < target) {
            return;
        }
        // 현재 노드 범위에 변경할 data index(target)이 포함되는 경우
        // 내려가면서 다른 원소도 갱신
        else {
            // target 번째 수를 val로 변경한다면, 그 수가 얼마만큼 변했는지를 알아야 합니다.
            // 이 수를 diff 라고 하면, diff = val - a[target]로 쉽게 구할 수 있습니다.
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }


}