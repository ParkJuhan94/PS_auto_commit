//package BOJ.Section04.P1159;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section04/P1159/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            alpha[str.charAt(0) - 'a']++;
        }

        int flag = 0;
        for(int i = 0; i < 26; i++){
            if(alpha[i] >= 5){
                char c = (char)('a' + i);
                sb.append(c);
                flag = 1;
            }
        }

        if(flag == 1){
            System.out.println(sb);
        }else{
            System.out.println("PREDAJA");
        }
    }

}