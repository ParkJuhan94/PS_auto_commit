//package BOJ.Section09.P1522;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //ystem.setIn(new FileInputStream("src/BOJ/Section09/P1522/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strLen = str.length();

        int cntA = 0;
        for(int i = 0; i < strLen; i++){
            if(str.charAt(i) == 'a'){
                cntA++;
            }
        }

        int answer = strLen;

        for(int i = 0; i < strLen; i++){
            int cntB = 0;
            for(int j = i; j < i + cntA; j++){
                if(str.charAt(j % strLen) == 'b'){
                    cntB++;
                }
            }

            answer = Math.min(answer, cntB);
        }

        System.out.println(answer);
    }

}
