//package DAY03.P2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int A, B, C;
    static int MAX = 1000000; // 맛의 종류가 1,000,000 개
    static int[] tree;
    static int S;

    public static void main(String[] args) throws Exception {
   //     System.setIn(new FileInputStream("src/DAY03/P2243/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = 1;
        while (S < MAX) {
            S *= 2;
        }
        tree = new int[2 * S];
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());

            if (A == 2) {
                //  A가 2인 경우는 사탕을 넣는 경우이다. 이때에는 두 정수가 주어지는데,
                //  B는 넣을 사탕의 맛을 나타내는 정수이고 C는 그러한 사탕의 개수이다.
                //  C가 양수일 경우에는 사탕을 넣는 경우이고, 음수일 경우에는 빼는 경우이다.
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());

                update(1, S, 1, B, C);
            } else if (A == 1) {
                //  A가 1인 경우는 사탕상자에서 사탕을 꺼내는 경우이다. 이때에는 한 정수만 주어지며,
                //  B는 꺼낼 사탕의 순위를 의미한다. 이 경우 사탕상자에서 한 개의 사탕이 꺼내지게 된다.
                B = Integer.parseInt(st.nextToken());

                int index = query(1, S, 1, B);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }
        }
    }

    static void update(int left, int right, int node, int target, int diff){
        if(target < left || right < target){
            return;
        }else {
            tree[node] += diff;
            if(left != right){
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    // 사탕의 순위를 넣어서 몇의 맛인지 반환함
    static int query(int left, int right, int node, int count) {
        // 1. Leaf 에 도착했을때 -> 사탕 번호 반환
        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            // 2. 왼쪽 >= count -> 왼쪽으로 이동
            if (tree[node * 2] >= count) {
                return query(left, mid, node * 2, count);
            }
            // 3. 왼쪽 < count -> 오른쪽으로 이동
            else {
                count -= tree[node * 2];
                return query(mid + 1, right, node * 2 + 1, count);
            }
        }
    }

//    static void update(int left, int right, int node, int index, long diff) {
//        if (left <= index && index <= right) {
//            tree[node] += diff;
//            if (left != right) {
//                int mid = (left + right) / 2;
//                update(left, mid, node * 2, index, diff);
//                update(mid + 1, right, node * 2 + 1, index, diff);
//            }
//        }
//    }
}