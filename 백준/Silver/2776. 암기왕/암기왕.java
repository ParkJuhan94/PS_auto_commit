//package BOJ.Section08.P2776;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums1;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section08/P2776/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            N = Integer.parseInt(br.readLine());
            nums1 = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                nums1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums1);


            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++){
                int target = Integer.parseInt(st.nextToken());

                if(binarySearch(target)){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean binarySearch(int target) {
        int start = 0;
        int end = N - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums1[mid] == target){
                return true;
            }else if (nums1[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;
    }
}
