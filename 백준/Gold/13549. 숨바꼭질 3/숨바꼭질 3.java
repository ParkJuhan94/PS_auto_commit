//package WEEK00.P13549;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK00/P13549/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int[] map = new int[100001];
        boolean[] ch = new boolean[100001];
        q.add(N);
        ch[N] = true;
        int ans = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K){
                ans = map[cur];
                break;
            }

            if(cur * 2 <= 100000 && !ch[cur * 2]){
                q.add(cur * 2);
                map[cur * 2] = map[cur];
                ch[cur * 2] = true;
            }

            if(cur - 1 >= 0 && !ch[cur - 1]){
                q.add(cur - 1);
                map[cur - 1] = map[cur] + 1;
                ch[cur - 1] = true;
            }

            if(cur + 1 <= 100000 && !ch[cur + 1]){
                q.add(cur + 1);
                map[cur + 1] = map[cur] + 1;
                ch[cur + 1] = true;
            }
        }

        System.out.println(ans);
    }
}