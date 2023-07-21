//package BOJ.Section06.P28359;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section06/P28359/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = 0;
        // 감소하지 않는 부분수열
        for(int i = 0; i < arr.length; i++){
            ans += arr[i];
        }

        // 증가하지 않는 감소수열
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }else{
                hashMap.put(arr[i], 1);
            }
        }

        int max = 0;
        for(int key : hashMap.keySet()){
            if(key * hashMap.get(key) > max){
                max = key * hashMap.get(key);
            }
        }
        ans += max;

        System.out.println(ans);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}