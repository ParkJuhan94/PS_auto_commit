class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] divideStr = quiz[i].split(" ");
            int x = Integer.parseInt(divideStr[0]);
            int y = Integer.parseInt(divideStr[2]);
            int z = Integer.parseInt(divideStr[4]);
            String operator = divideStr[1];
            
            // 연산 결과 계산
            int result = operator.equals("+") ? x + y : x - y;
            
            // 결과 확인 후 "O" 또는 "X" 저장
            answer[i] = result == z ? "O" : "X";
        }
        
        return answer;
    }
}