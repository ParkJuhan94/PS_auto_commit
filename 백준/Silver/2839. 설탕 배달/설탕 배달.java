//package WEEK20.P2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/WEEK20/P2839/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sugar, cnt = 0;
        sugar = Integer.parseInt(st.nextToken());

        /*
        먼저 3키로씩 빼다가 5키로로 나누어 떨어지는 순간 계산하여 break;
         */
        while (true)
        {
            if (sugar % 5 == 0)
            {
                cnt += sugar / 5;
                System.out.println(cnt);
                break;
            }

            sugar -= 3;
            cnt++;

            // 3키로랑 5키로 둘 다 안되는 경우
            if (sugar <= -1)
            {
                System.out.println(-1);
                break;
            }
        }
    }

}









