//package DAY04.P3955;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int t,A,B;
    static EGResult result;

    // -Ax + By = 1
    // A(-x) + By = 1 로 변환
    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/DAY04/P3955/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < t; i++){
            // -Kx + Cy = -1 -> y를 구해야함
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 1. 해 검증
            result = extendedGcd(A, B);
            if(result.r != 1) System.out.println("IMPOSSIBLE");
            else{
                // 2. 초기 해 구하기
                long x0 = result.s;
                long y0 = result.t;

                // 3. 일반 해 구하기

                // 4. k의 범위
                //  더 작은 k를 구하기 위해 올림 후에 -1 한다. (바로 내림 하면 안됨 !!!)
                long kFromY = (long) Math.ceil((double) y0 / (double) A) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) B) - 1;
                long k = Math.min(kFromY, kFromX);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A);

                // 5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
                if(kLimitFromY <= k){
                    System.out.println(y0 - A * k);
                }else{
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }

    static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while(r1 != 0){
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }

        return new EGResult(s0, t0, r0);
    }

    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

class EGResult{
    long s,t,r;

    public EGResult(long s, long t, long r){
        super();
        this.s = s;
        this.r = r;
        this.t = t;
    }
}
