class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] divideStr = quiz[i].split(" ");
            int x = Integer.parseInt(divideStr[0]);
            int y = Integer.parseInt(divideStr[2]);
            int z = Integer.parseInt(divideStr[4]);
            String firstOperator = divideStr[1];
            
            if(firstOperator.equals("+")) {
                if(x + y == z) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else {
                  if(x - y == z) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        
        return answer;
    }
}