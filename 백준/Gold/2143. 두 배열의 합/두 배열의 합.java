//package DAY02.P2143;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static long T, sum = 0;
    static int n,m;
    static long[] A,B;

    public static void main(String args[]) throws IOException {
      //  System.setIn(new FileInputStream("src/DAY02/P2143/input.txt"));

        BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        A = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        B = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        //모든 부배열의 합을 저장 : 부배열의 개수는 n * (n + 1) / 2
        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        //subA 구하기 : O(n^2)
        for(int i = 0; i < n; i++){
            sum = A[i];
            subA.add(sum);
            for(int j = i + 1 ; j < n; j++){
                sum += A[j];
                subA.add(sum);
            }
        }

        //subB 구하기 : : O(m^2)
        for(int i = 0; i < m; i++){
            sum = B[i];
            subB.add(sum);
            for(int j = i + 1 ; j < m; j++){
                sum += B[j];
                subB.add(sum);
            }
        }

        //subA, subB 정렬하기 : subA는 오름차순, subB는 내림차순
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        //투포인터
        long result = 0;
        int pA = 0;
        int pB = 0;
        while(true){
            long currentA = subA.get(pA);
            long target = T - currentA;

            //currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기. pA++ pB++
            if(subB.get(pB) == target){
                long cntA = 0;
                long cntB = 0;

                while(pA < subA.size() && subA.get(pA) == currentA){
                    cntA++;
                    pA++;
                }

                while(pB < subB.size() && subB.get(pB) == target){
                    cntB++;
                    pB++;
                }

                result += cntA * cntB;
            }

            //currentB > target -> pB++
            else if(subB.get(pB) > target) pB++;

            //currentB < target -> pA++
            else pA++;

            //탈출 조건
            if(pA == subA.size() || pB == subB.size()) break;
        }

        System.out.println(result);
    }
}

