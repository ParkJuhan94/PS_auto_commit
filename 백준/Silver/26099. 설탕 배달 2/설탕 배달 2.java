//package WEEK000.P26099;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger N;
    static int M;
    static int[][] map;
    static int[][] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/WEEK000/P26099/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger sugar, cnt = new BigInteger("0");
        sugar = new BigInteger(st.nextToken());

        /*
        먼저 3키로씩 빼다가 5키로로 나누어 떨어지는 순간 계산하여 break;
         */
        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("3");

        while (true)
        {
            if (sugar.remainder(a).compareTo(new BigInteger("0")) == 0) {
                cnt = cnt.add(sugar.divide(a));
                System.out.println(cnt);
                break;
            }

            sugar = sugar.subtract(b);
            cnt = cnt.add(new BigInteger("1"));

            // 3키로랑 5키로 둘 다 안되는 경우
            if (sugar.compareTo(new BigInteger("-1")) < 0)
            {
                System.out.println(-1);
                break;
            }
        }
    }

}