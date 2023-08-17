//package BOJ.Section07.P1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section07/P1253/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        Arrays.sort(nums);

        for(int i = 0; i < N; i++){
            int p1 = 0;
            int p2 = nums.length - 1;

            while(true){
                // 다른 수를 선택하도록
                if(p1 == i) p1++;
                if(p2 == i) p2--;
                if(p1 >= p2) break;

                if(nums[i] == nums[p1] + nums[p2]){
                    ans++;
                    break;
                }else{
                    if(nums[i] < nums[p1] + nums[p2]){
                        p2--;
                    }else{
                        p1++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}