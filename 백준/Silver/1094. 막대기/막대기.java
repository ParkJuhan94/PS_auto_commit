//package BOJ.Section08.P1094;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section08/P1094/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        /*
        23 -> 4 ->   10111
        32 -> 1 ->  100000
        64 -> 1 -> 1000000
        48 -> 2 ->  110000
         */

        String xToBinary = Integer.toBinaryString(X);
        int ans = 0;
        for(int i = 0; i < xToBinary.length(); i++){
            if(xToBinary.charAt(i) == '1'){
                ans++;
            }
        }

        System.out.println(ans);
    }

}
