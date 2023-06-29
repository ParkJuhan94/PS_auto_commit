//package BOJ.Section04.P1268;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section04/P1268/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] students = new int[N][5];
        int[][] count = new int[N][N];
        int[] countSum = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 5; j++){
                for(int k = i + 1; k < N; k++){     // 자기 자신을 중복 카운트하는것 제외
                    if(students[i][j] == students[k][j]){
                        count[i][k] = 1;
                        count[k][i] = 1;
                    }
                }
            }
        }

        // 합계 구하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(count[i][j] == 1){
                    countSum[i]++;
                }
            }
        }

        // 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
        int ans = 0;
        int max = 0;
        for(int i = N - 1; i >= 0; i--){
            if(countSum[i] >= max){
                max = countSum[i];
                ans = i + 1;
            }
        }
        
        System.out.println(ans);
    }

}