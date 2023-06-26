//package BOJ.Section04.P1110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P1110/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int ans = 0;
        int temp = N;

        do{
            if(temp < 10){
                temp = (temp) * 10 + temp;
                //System.out.println(temp);
            }else{
                temp = (temp % 10) * 10 + ((temp / 10) + temp % 10) % 10;
                //System.out.println(temp);
            }
            ans++;
        }while(temp != N);

        System.out.println(ans);
    }

}