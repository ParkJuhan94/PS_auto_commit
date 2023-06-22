class Solution {

    public int isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    // 약수 중에서 자신을 제외하고 가장 큰 수를 리턴
    // 선형탐색 시간초과 -> 에라토테네스의 채
    // n이 10억이면, 제곱근은 31000+
    /*
        [begin, end] = [100000014, 100000016] 를 테스트했을 때,
        [1, 1, 6250001]이 아닌 [6, 5, 6250001]이 출력되어야 합니다.

        왜냐하면, 100000014 = 6 * 16666669(소수)이고,
                100000015 = 5 * 20000003(소수)라서
        문제의 조건대로라면 각각 6번, 5번 블록이 깔려 있어야 하기 때문입니다.
     */

    public int divisor(long n){
        int res = -1;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                res = i;

                if(n / i <= 10000000){
                    return (int)n / i;
                }
            }
        }

        return res;
    }

    // begin 과 end 범위가 10억인데 왜 굳이 long을 ?
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int)end - (int)begin + 1];
        int ansIdx = 0;
        // end - begin ≤ 5,000  (N = 5000)
        // 1. 소수면 1
        // 2. 소수 아니면 약수 중 자신을 제외하고 가장 큰 수
        //    -> 2천만 이상일 때는 약수 중 천만 이하의 가장 큰 수

        for(long i = begin; i <= end; i++){
            // 인덱스 1 예외처리
            if(i == 1){
                answer[ansIdx++] = 0;
                continue;
            }

            if(isPrime(i) == 1){
                answer[ansIdx++] = 1;
            }else{
                answer[ansIdx++] = divisor(i);
            }
        }

        return answer;
    }
}
