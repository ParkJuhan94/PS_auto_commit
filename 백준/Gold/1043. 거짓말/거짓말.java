//package WEEK00.P1043;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] ch;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/WEEK00/P1043/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];    // 1이면 진실을 알고있는 사람, 0이면 모르는 사람


        st = new StringTokenizer(br.readLine());
        int numPeople = Integer.parseInt(st.nextToken());
        for(int i = 0; i < numPeople; i++){
            int num = Integer.parseInt(st.nextToken());
            ch[num] = 1;
        }

        // 파티정보 입력받기
        // 갱신되는 사람이 없을때까지 반복
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < M; i++){
            ArrayList<Integer> newRow = new ArrayList<>();
            arr.add(newRow);

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++){
                int cur = Integer.parseInt(st.nextToken());
                arr.get(i).add(cur);
            }
        }

        while(true){
            int flag = 0;

            for(int i = 0; i < M; i++){
                // 포함되어있으면 그 그룹 모두를 진실을 아는 사람으로 갱신
                for(int j = 0; j < arr.get(i).size(); j++){
                    // 진실을 아는 사람이 포함되어있냐?
                    if(ch[arr.get(i).get(j)] == 1){
                        for(int k = 0; k < arr.get(i).size(); k++){
                            if(ch[arr.get(i).get(k)] == 0){
                                ch[arr.get(i).get(k)] = 1;
                                flag = 1;
                            }
                        }
                    }
                }
            }

            if(flag == 0){
                break;
            }
        }

        int flag = 0;
        for(int i = 0; i < M; i++){
            flag = 0;
            for(int j = 0; j < arr.get(i).size(); j++){
                if(ch[arr.get(i).get(j)] == 1){
                    flag = 1;
                }
            }
            if(flag == 0){
                //System.out.println(i + "번 파티에서 거짓말 가능");
                ans++;
            }
        }

        //System.out.print(sb);
        System.out.println(ans);
    }

}