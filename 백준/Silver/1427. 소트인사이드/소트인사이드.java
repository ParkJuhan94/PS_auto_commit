//package BOJ.Section04.P1427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P1427/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < str.length(); i++){
            pq.add(str.charAt(i));
        }

        int len = pq.size();
        for(int i = 0; i < len; i++){
            System.out.print(pq.poll());
        }
    }

}