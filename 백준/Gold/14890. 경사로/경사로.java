//package BOJ.Section06.P14890;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2:30 start
public class Main {
    static int N, L;
    static int[][] map;
    static int ans = 0;
    static int width;
    static int prev;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section06/P14890/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search();

        System.out.println(ans);
    }

    static void search() {
        for(int r = 0; r < N; r++){
            // 왼쪽부터
            width = 1;
            prev = map[r][0];
            isPossible = true;
            int c;
            for(c = 1; c < N; c++)
            {
                int cur = map[r][c];

                // 이전과 높이가 같은가
                if(cur == prev){
                    width++;
                }else if(cur == prev + 1) {  // 1 높아지는가
                    // 경사로를 놓을 면적이 되는가
                    if (width >= L) {     // 경사로 놓는다.
                        width = 1;
                        prev = cur; // 이전 높이를 현재 높이로 갱신
                    } else {      // 경사로 설치 불가능 -> 탈출
                        break;
                    }
                }else if(cur == prev - 1){  // 1 낮아지는가
                    // 내리막길 경사로 설치 가능한가
                    prev = cur;
                    for(int i = 1; i <= L - 1; i++) {
                        c++;          // 열 하나 증가
                        if(c >= N){   // map 벗어나면
                            isPossible = false;
                            break;
                        }

                        cur = map[r][c];

                        // 이전과 높이가 다른가
                        if(cur != prev) {
                            isPossible = false;
                            break;
                        }
                    }

                    if(!isPossible){
                        break;
                    }else{
                        width = 0;  // 경사로 놓는다.
                    }
                }else{
                    break;  // 경사로 설치 불가능 -> 탈출
                }
            }
            // 경사로를 놓았든 안 놓았든 끝까지 왔다면 카운트 (또한 내리막 경사로 설치에 문제가 없었다면)
            if(c == N && isPossible) {
                ans++;
               // System.out.println(r + "행");
            }
        }

        for(int c = 0; c < N; c++){
            // 위에서부터
            width = 1;
            prev = map[0][c];
            isPossible = true;
            int r;
            for(r = 1; r < N; r++)
            {
                int cur = map[r][c];

                if(cur == prev){
                    width++;
                }else if(cur == prev + 1){
                    if(width >= L){
                        width = 1;
                        prev = cur;
                    }else{
                        break;
                    }
                }else if(cur == prev - 1){
                    prev = cur;
                    for(int i = 1; i <= L - 1; i++) {
                        r++;          
                        if(r >= N){   
                            isPossible = false;
                            break;
                        }

                        cur = map[r][c];
                        
                        if(cur != prev) {
                            isPossible = false;
                            break;
                        }
                    }

                    if(!isPossible){
                        break;
                    }else{
                        width = 0;  
                    }
                }else{
                    break;
                }
            }
            if(r == N && isPossible) {
                ans++;
               // System.out.println(c + "열");
            }
        }
    }


}