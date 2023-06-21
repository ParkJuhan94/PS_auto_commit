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
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //N = Integer.parseInt(st.nextToken());

        int max = 0;
        int maxIdx = -1;
        for(int i = 0; i < 9; i++){
            int input = Integer.parseInt(br.readLine());
            if(input > max){
                max = Math.max(max, input);
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx + 1);

//        int ans = 0;
//
//
//        System.out.println(ans);
    }

}