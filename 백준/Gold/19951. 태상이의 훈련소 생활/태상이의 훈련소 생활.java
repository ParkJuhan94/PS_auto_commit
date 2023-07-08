//package BOJ.Section05.P19951;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 템플릿 없이 직접 구현

public class Main {
    static int N, M;
    static int[] nums;
    static int[] sums;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section05/P19951/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 2];
        sums = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sums[a] += k;
            sums[b + 1] -= k;
        }

        int tmp = 0;
        for(int i = 1; i <= N; i++){
            tmp += sums[i];
            nums[i] += tmp;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(nums[i] + " ");
        }

    }

}
