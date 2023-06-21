//package DAY02.P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] trees;

    public static void main(String Args[]) throws IOException {
       // System.setIn(new FileInputStream("src/DAY02/P2805/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long s = 0;
        long e = max;
        long mid;
        long result = 0;

        while(true){
            mid = (s + e) / 2;
            long sum = calc(mid);

            //sum == M -> 정답, 탈출
            if(sum == M){
                result = mid;
                break;
            }

            //sum < M -> mid -> end
            else if(sum < M){
                e = mid - 1;
            }

            //sum > M -> mid -> s, 정답 후보
            else{
                result = mid;
                s = mid + 1;
            }

            //탈출 조건
            if(s > e) break;
        }

        System.out.println(result);
    }

    static long calc(long value){
        long result = 0;
        for(int i = 0; i < trees.length; i++){
            int tree = trees[i];
            if(tree > value){
                result += tree - value;
            }
        }
        return result;
    }
}
