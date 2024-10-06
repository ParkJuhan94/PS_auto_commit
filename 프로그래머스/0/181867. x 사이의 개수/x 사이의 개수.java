class Solution {
    public int[] solution(String myString) {
        int[] answer;
        
        String[] arrStr = myString.split("x");
        answer = new int[arrStr.length];
        for(int i = 0; i < arrStr.length; i++) {
            answer[i] = arrStr[i].length();
        }
        
        
        // 만약 문자열이 "x"로 끝나면 빈 문자열에 대한 길이도 추가합니다.
        if (myString.endsWith("x")) {
            answer = java.util.Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = 0;
        }
        
        return answer;
    }
}