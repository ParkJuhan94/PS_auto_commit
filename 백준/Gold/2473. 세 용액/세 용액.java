//package BOJ.Section07.P2473;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] nums;
    static long min = 3_000_000_000L;
    static long[] ansArr = new long[3];

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section07/P2473/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        // N = 5000
        // i, left, right 오름차순
        for (int i = 0; i < N - 2; i++)
        {
            int left = i + 1;
            int right = N - 1;

            while (left < right)
            {
                long sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum) < min)
                {
                    min = Math.abs(sum);

                    ansArr[0] = nums[i];
                    ansArr[1] = nums[left];
                    ansArr[2] = nums[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    i = N;
                    break;   
                }
            }
        }

        for(long n : ansArr){
            System.out.print(n + " ");
        }
    }

}