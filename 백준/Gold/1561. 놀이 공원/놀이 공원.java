//package BOJ.Section08.P1561;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max, M, answer;
    static long N, targetTime;
    private static int[] times;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section08/P1561/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, times[i]);
        }

        if(N <= M){
            System.out.println(N);
            return;
        }
        
        binarySearch();

        // targetTime 에서 1분씩 줄이면서 마지막 아이가 타는 놀이기구 번호 확인
        // 1. 직전에 탄 아이의 수 = 19
        int sum = 0;
        for(int i = 0; i < M; i++){
            sum += (targetTime - 1) / times[i] + 1;
        }

        // sum = 19
        // 2. 현재에 탄 아이의 수 = 22
        for(int i = 0; i < M; i++){
            if(targetTime % times[i] == 0) {
                sum++;
            }
            if(sum == N) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    // N명 이상을 태울 수 있는 최소 시간 도출
    public static void binarySearch() {
        long left = 0;
        long right = N * max;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < M ; i++) {
                sum += ((mid / times[i]) + 1);
            }

            // 8분 5 + 8 + 4 + 2 + 2 + 1 = 22
            if(N <= sum) {
                targetTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

}
