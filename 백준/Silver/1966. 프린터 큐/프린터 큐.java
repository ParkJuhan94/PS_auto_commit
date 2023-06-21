//package BOJ.Silver.P1966;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, TC, cnt, maxImport;
    static Queue<Node> Q;
    static PriorityQueue<Integer> PQ;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Silver/P1966/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= TC; tc++){
            cnt = 1;
            Q = new LinkedList<>();
            PQ = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int importance_ = Integer.parseInt(st.nextToken());
                Q.add(new Node(i, importance_));
                PQ.add(importance_);
            }

            while(!Q.isEmpty()){
                maxImport = PQ.peek();
                Node front = Q.poll();

                //System.out.println("front : " + front.idx + ", " + front.importance);
                //System.out.println("maximport : " + maxImport);
                // Q의 제일 앞 문서가 원하는 idx 이고, 뒤에 더 높은 중요도가 없으면
                if(front.idx == M &&
                        front.importance == maxImport) {
                    break;
                }

                // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면
                // 이 문서를 인쇄하지 않고 Q의 가장 뒤에 재배치
                if(front.importance < maxImport){
                    Q.add(front);
                }
                // 그렇지 않다면 바로 인쇄
                else{
                    PQ.poll();
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}

class Node{
    int idx;
    int importance;

    @Override
    public String toString() {
        return "{" +
                idx +
                ", " + importance +
                '}';
    }

    public Node(int idx, int importance) {
        this.idx = idx;
        this.importance = importance;
    }
}
