class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long sum = 0;   // 1사분면 위의 정수 쌍 갯수

        long r1x = (long)r1 * r1;
        long r2x = (long)r2 * r2;

        for(int i = 1; i <= r2; i++){
            if(i < r1){
                double y1 = Math.floor(Math.sqrt(r1x - (long)i * i));
                double y2 = Math.floor(Math.sqrt(r2x - (long)i * i));

                if(isInteger(Math.sqrt(r1x - (long)i * i))){
                    sum += y2 - y1 + 1;
                }else{
                    sum += y2 - y1;
                }
            }else{
                sum += Math.floor(Math.sqrt(r2x - (long)i * i)) + 1;
            }
        }

        answer = 4 * sum;
        return answer;
    }

    public boolean isInteger(double num) {
        return num == (int) num;
    }
}