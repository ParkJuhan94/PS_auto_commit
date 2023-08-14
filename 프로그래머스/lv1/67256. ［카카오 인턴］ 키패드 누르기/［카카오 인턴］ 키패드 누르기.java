class Solution {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        int left = 10;
        int right = 12;

        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];

            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                left = num;
            }else if(num == 3 || num == 6 || num == 9){
                answer += "R";
                right = num;
            }else{
                if(dist(left, num) != dist(right, num)){   // 거리가 다르다면
                    if(dist(left, num) < dist(right, num)){
                        answer += "L";
                        left = num;
                    }else{
                        answer += "R";
                        right = num;
                    }
                }else{  // 거리가 같다면
                    if(hand.equals("left")){
                        answer += "L";
                        left = num;
                    }else{
                        answer += "R";
                        right = num;
                    }
                }
            }
        }

        return answer;
    }

    int dist(int a, int b){
        if(a == 0){
            a = 11;
        }
        if(b == 0){
            b = 11;
        }

        int res = 0;

        res += Math.abs(a - b) / 3;
        res += Math.abs(a - b) % 3;

        return res;
    }
}