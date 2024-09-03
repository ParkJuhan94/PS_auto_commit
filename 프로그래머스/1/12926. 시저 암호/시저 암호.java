class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 소문자 처리
            if(c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + n) % 26);
            }
            // 대문자 처리
            else if(c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + n) % 26);
            }
            
            answer.append(c);
        }

        return answer.toString();
    }
}