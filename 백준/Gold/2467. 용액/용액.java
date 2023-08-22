//package BOJ.Section07.P2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] ans = new int[2];
    static long sum = 0;
    static long min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section07/P2467/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = N - 1;

        while (p1 < p2) {
            sum = nums[p1] + nums[p2];

            if(Math.abs(sum) < min){
                ans[0] = nums[p1];
                ans[1] = nums[p2];
                min = Math.abs(sum);
            }

            if(sum == 0){
                ans[0] = nums[p1];
                ans[1] = nums[p2];
                break;
            } else if(sum > 0){
                p2--;
            }else{
                p1++;
            }
        }

        System.out.print(ans[0] + " " + ans[1]);
    }

}