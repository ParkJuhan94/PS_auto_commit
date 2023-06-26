//package WEEK0.P11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK0/P11723/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[21];
        int bitset = 0;

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = 0;

            if(order.equals("add") || order.equals("remove")
                    || order.equals("check") || order.equals("toggle")){
                num = Integer.parseInt(st.nextToken());
            }

            if(order.equals("add"))
            {
                bitset |= (1 << (num - 1));
            }
            else if(order.equals("remove"))
            {
                bitset = bitset & ~(1 << (num - 1));
            }
            else if(order.equals("check"))
            {
                sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
            }
            else if(order.equals("toggle"))
            {
                bitset ^= (1 << (num - 1));
            }
            else if(order.equals("all"))
            {
                bitset |= (~0);
            }
            else if(order.equals("empty"))
            {
                bitset &= 0;
            }
        }
        System.out.println(sb.toString());
    }

}