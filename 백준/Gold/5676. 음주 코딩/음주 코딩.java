//package BOJ.Section05.P5676;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] tree;
    static int leafStart;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section05/P5676/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = "";
        while((input = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nums = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0){
                    nums[i] = 0;
                }else{  // 오버플로우 방지 -> 100^(10^5)
                    nums[i] = (num > 0) ? 1 : -1;
                }
            }

            leafStart = 1;
            while (leafStart < N) {
                leafStart *= 2;
            }
            tree = new int[2 * leafStart];

            initTree();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

                // 1부터 leafStart 까지!
                // 1부터 N까지 아님
                if (order.equals("C")) {
                    int target = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    if(value != 0){
                        value = (value > 0) ? 1 : -1;
                    }

                    update(1, leafStart,1, target, value);

                } else if (order.equals("P")) {
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());

                    int multiply = query(1, leafStart, 1, s, e);

                    if(multiply > 0){
                        System.out.print("+");
                    }else if(multiply == 0){
                        System.out.print(0);
                    }else{
                        System.out.print("-");
                    }
                }
            }
            System.out.println();
        }
    }

    static void initTree() {
        // tree를 1로 초기화 (곱이니까 0이면 안돼)
        for(int i = 0; i < 2 * leafStart; i++){
            tree[i] = 1;
        }
        // leaf 노드 채우기
        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = nums[i];
        }
        // 내부 노드 채우기
        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1];
        }
    }

    // 구간곱 구하기
    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 구간곱의 start, 구간곱의 end)
    static int query(int left, int right, int node, int queryLeft, int queryRight) {
        // 구간곱의 범위에 전혀 연관이 없는 경우 : 곱이니까 0이 아닌 1리턴
        if (left > queryRight || right < queryLeft) {
            return 1;
        }
        // 구간곱의 범위에 현재 노드 범위 전체가 포함되는 경우 (쪼개다가 이까지 도달해야해)
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 구간곱의 범위에 현재 노드 범위 일부가 포함되는 경우
        else {
            int mid = (left + right) / 2;
            int resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            int resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultLeft * resultRight;
        }
    }

    // (현재 노드의 왼쪽 범위, 현재 노드의 오른쪽 범위, 현재 노드 index, 변경할 data index, 변경할 값)
    static int update(int left, int right, int node, int target, int val) {

        if(target < left || right < target){
            return tree[node];
        }

        // 구간합은 위에서부터 리프 노드로 갔어도 가능 -> 0에서 더하기만 하면 복구되니까
        // 구간곱은 이와 다르게, 리프 노드부터 위로   -> 0으로 초기화된 것을 복구시켜놓고 올라오도록!
        // update 가 void 면 안된다. long 을 반환해서 재귀를 타도록!

        // 리프에서는 val로 변경
        if(left == right){
            return tree[node] = val;
        }

        int mid = (left + right) / 2;
        return tree[node] = update(left, mid, node * 2, target, val) *
                update(mid + 1, right, node * 2 + 1, target, val);
    }
}