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

   int dist(int a, int b) {
        // 키패드의 숫자 0은 내부적으로 11번 위치로 처리
        if (a == 0) a = 11;
        if (b == 0) b = 11;

        // 맨해튼 거리 계산
        int rowDiff = Math.abs((a - 1) / 3 - (b - 1) / 3); // 행(row) 차이
        int colDiff = Math.abs((a - 1) % 3 - (b - 1) % 3); // 열(col) 차이
       
        return rowDiff + colDiff;
}
}