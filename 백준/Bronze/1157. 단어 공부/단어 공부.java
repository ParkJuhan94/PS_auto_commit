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
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        int[] alpha = new int[26];

        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if('a' <= cur && cur <= 'z'){   // 소문자면
                alpha[cur - 'a']++;
            } else {        // 대문자면
                alpha[cur - 'A']++;
            }
        }

        int max = -1;
        char ans = 'A';
        int maxIdx = 0;

        for(int i = 0; i < 26; i++){
            if(alpha[i] > max){
                max = alpha[i];
                maxIdx = i;
            }
        }
        ans += maxIdx;

        // 중복 검사
        int flag = 0;
        for(int i = 0; i < 26; i++){
            if(alpha[i] == max){
                flag++;
            }
        }

        if(flag >= 2){
            System.out.println("?");
        } else {
            System.out.println(ans);
        }
    }

}