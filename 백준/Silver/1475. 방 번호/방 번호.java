//package TEST.P1475;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    // 6과9 호환 주의
    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/TEST/P1475/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int cnt[] = new int[10];
        int ans=0;

        for (int i = 0; i < tmp.length(); i++) {
            cnt[tmp.charAt(i)-'0']++;
        }

        //6과 9의 총 개수를 파악 -> 짝 인지 홀 인지
        int six=0;
        for (int i = 0; i < 10; i++) {
            if(i==6||i==9) {
                six+=cnt[i];
                continue;
            }
            ans=Math.max(ans, cnt[i]);
        }
        if(six%2==0) {
            ans=Math.max(ans, six/2);
        }else {
            ans=Math.max(ans, six/2+1);
        }

        System.out.println(ans);
    }
}