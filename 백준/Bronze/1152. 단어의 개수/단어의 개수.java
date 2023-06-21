//package WEEK0.P90;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK0/P90/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ans = 0;

        while(st.hasMoreTokens()){
            st.nextToken();
            ans++;
        }

        System.out.println(ans);
    }

}