class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long sum = 0;   // 1사분면 위의 정수 쌍 갯수

        long firstPow = (long)r1 * r1;
        long secondPow = (long)r2 * r2;

        for(int i = 1; i <= r2; i++){
            if(i < r1){
                long tmp = sum;
                double firstRange = Math.floor(Math.sqrt(firstPow - (long)i * i));
                double secondRange = Math.floor(Math.sqrt(secondPow - (long)i * i));

                if(isInteger(Math.sqrt(firstPow - (long)i * i))){
                    sum += secondRange - firstRange + 1;
                }else{
                    sum += secondRange - firstRange;
                }
                //System.out.println(sum - tmp);
            }else{
                long tmp = sum;
                sum += Math.floor(Math.sqrt(secondPow - (long)i * i)) + 1;
                //System.out.println(sum - tmp);
            }
        }

        answer = 4 * sum;
        return answer;
    }

    public boolean isInteger(double num) {
        return num == (int) num;
    }
}