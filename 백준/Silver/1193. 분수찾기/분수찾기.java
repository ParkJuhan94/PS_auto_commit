//package WEEK0.P1193;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK0/P1193/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        int sum = 0;
        int i = 1;  // 분자와 분모의 합으로 쓸 것임

        while(sum + i < N){
            sum += i;
            i++;
        }

        if(i % 2 == 1){
            System.out.println((i + 1 - (N - sum)) + "/" + (N - sum));
        }else{
            System.out.println((N - sum) + "/" + (i + 1 - (N - sum)));
        }

    }

}