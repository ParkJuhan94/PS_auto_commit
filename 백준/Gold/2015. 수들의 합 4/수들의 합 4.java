//package BOJ.Section04.P2015;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] sums;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P2015/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        sums = new int[N];
        map = new HashMap<>();
        long ans = 0;

        /*
        nums : 2 -2 2 -2
        sums : 2  0 2  0
         */

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
            sums[i] = sum;
        }

        for(int i = 0; i < N; i++){
            int diff = sums[i] - M;

            // map 에서 꺼내서 확인
            if(sums[i] == M) ans++;

            if(map.containsKey(diff)){
                ans += map.get(diff);
            }

            // map에 넣어주기
            if(map.containsKey(sums[i])){
                map.put(sums[i], map.get(sums[i]) + 1);
            }else{
                map.put(sums[i], 1);
            }
        }

        System.out.println(ans);
    }

}