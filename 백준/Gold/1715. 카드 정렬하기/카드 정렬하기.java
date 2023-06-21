//package WEEK19.P1715;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK19/P1715/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        // pq에 1개 남을때까지 진행
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            ans += a+b;
            pq.add(a+b);
        }

        System.out.println(ans);
    }
}