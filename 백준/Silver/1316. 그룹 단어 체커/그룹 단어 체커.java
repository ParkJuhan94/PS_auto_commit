//package WEEK0.P1316;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/WEEK0/P1316/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        alpha = new int[26];

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            alpha = new int[26];
            String str = br.readLine();
            int len = str.length();

            // 한 단어 시작
            int flag = 0;
            alpha[str.charAt(0) - 'a']++;
            for(int j = 1; j < len; j++){
                if(str.charAt(j-1) != str.charAt(j) &&
                        alpha[str.charAt(j) - 'a'] != 0){
                    flag = 1;
                    break;
                }
                alpha[str.charAt(j) - 'a']++;
            }

            if(flag == 0){
                ans++;
            }
        }

        System.out.println(ans);
    }

}