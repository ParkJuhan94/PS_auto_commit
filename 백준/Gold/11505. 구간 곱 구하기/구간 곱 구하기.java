//package BOJ.Section05.P11505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P11505/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        //  if (N == 12)
        //  S : 1 -> 2 -> 4 -> 8 -> 16 -> while 탈출
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[2 * S];     //  long[32]

        initBU();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            long c;

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            // 1부터 S까지!
            // 1부터 N까지 아님
            if (a == 1) {
                update(1,S,1, b, c);
            } else if (a == 2) {
                System.out.println(query(1, S, 1, b, c));
            }
        }
    }

    static void initBU() {
        // tree를 1로 초기화 (곱이니까 0이면 안돼)
        for(int i = 0; i < 2 * S; i++){
            tree[i] = 1;
        }
        // leaf 노드 채우기
        for (int i = 0; i < N; i++) {
            tree[S + i] = nums[i];
        }
        // 내부 노드 채우기
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % MOD;
        }
    }

    // 구간곱 구하기
    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 구간곱의 start, 구간곱의 end)
    static long query(int left, int right, int node, int queryLeft, long queryRight) {
        // 구간곱의 범위에 전혀 연관이 없는 경우 : 곱이니까 0이 아닌 1리턴
        if (left > queryRight || right < queryLeft) {
            return 1;
        }
        // 구간곱의 범위에 현재 노드 범위 전체가 포함되는 경우 (쪼개다가 이까지 도달해야해)
        if (queryLeft <= left && right <= queryRight) {
            return tree[node] % MOD;
        }
        // 구간곱의 범위에 현재 노드 범위 일부가 포함되는 경우
        else {
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft * resultRight % MOD;
        }
    }

    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 변경할 data index, 변경할 값)
    static long update(int left, int right, int node, int target, long val) {

        if(target < left || right < target){
            return tree[node];
        }

        // 구간합은 위에서부터 리프 노드로 갔어도 가능했다 -> 0에서 더하기만 하면 복구되니까
        // 구간곱은 이와 다르게, 리프 노드부터 위로 -> 0으로 초기화된 것을 복구시켜놓고 올라오도록!
        // (update 가 void면 안된다. long을 반환해야함. 재귀를 타도록!)

        // 리프에서는 val로 변경
        if(left == right){
            return tree[node] = val;
        }

        int mid = (left + right) / 2;
        return tree[node] = update(left, mid, node * 2, target, val) *
                update(mid + 1, right, node * 2 + 1, target, val) % MOD;
    }

}