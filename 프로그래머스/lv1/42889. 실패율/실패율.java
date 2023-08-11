import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        Rate[] rates = new Rate[N];

        for(int i = 1; i <= N; i++){
            int a = 0;  // 분모
            int b = 0;  // 분자

            for(int j = 0; j < len; j++){
                if(stages[j] >= i){
                    a++;
                }
                if(stages[j] == i){
                    b++;
                }
            }
            if(a == 0){
                rates[i - 1] = new Rate(i, 0);
            }else{
                rates[i - 1] = new Rate(i, (double) b / a);
                System.out.println((double) b / a);
            }
        }

        Arrays.sort(rates);
        int idx = 0;
        for (Rate rate : rates) {
            answer[idx++] = rate.idx;
        }

        return answer;
    }
}

class Rate implements Comparable<Rate>{
    int idx;
    double rate;

    public Rate(int idx, double rate) {
        this.idx = idx;
        this.rate = rate;
    }

    @Override
    public int compareTo(Rate o) {
        if(rate == o.rate){
            return idx - o.idx;
        }else{
            if(o.rate > rate){
                return 1;
            }else{
                return -1;
            }
        }
    }
}