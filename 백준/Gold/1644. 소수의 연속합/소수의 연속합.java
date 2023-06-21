//package WEEK14.P1644;

import java.util.Scanner;

public class Main {
    static int[] check;
    static int[] primeNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        check = new int[N + 1];
        primeNum = new int[N + 1];
        int primeCnt = findPrime(N);
        System.out.println(PrimeSum(N, primeCnt));
    }

    // 2부터 N까지의 소수의 갯수를 반환 + 소수 셋팅
    public static int findPrime(int N) {
        int idxCnt = 0;
        for (int i = 2; i <= N; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                primeNum[idxCnt] = i;

                for (int j = i; j <= N; j = j + i) {
                    check[j] = 1;
                }
                idxCnt++;
            }
        }
        return idxCnt;
    }

    public static int PrimeSum(int N, int primeCnt) {
        int count = 0;
        int sum = 0;
        int s = 0;
        int e = 0;

        while (true) {
//            if (e >= primeNum.length) {break;}
            if (e >= primeCnt + 1) {break;}     // 자기 자신도 카운팅

            if (sum == N) {
//                for(int i = s; i < e; i++){
//                    System.out.print(primeNum[i] + " + ");
//                }
//                System.out.println();
//                sum += primeNum[e++];

                sum -= primeNum[s++];
                count++;
            } else if (sum < N) {
                sum += primeNum[e++];
            } else {
                sum -= primeNum[s++];
            }
        }

        return count;
    }
}



