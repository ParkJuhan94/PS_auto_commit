//package WEEK0.P1158;

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
      //  System.setIn(new FileInputStream("src/WEEK0/P1158/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        int tmp;
        int roof = 1;
        System.out.print("<");
        while(q.size() != 1){
            if(roof == K){
                tmp = q.poll();
                System.out.print(tmp + ", ");
                roof = 1;
            }else{
                tmp = q.poll();
                q.add(tmp);
                roof++;
            }
        }
        System.out.print(q.poll() + ">");
    }

}