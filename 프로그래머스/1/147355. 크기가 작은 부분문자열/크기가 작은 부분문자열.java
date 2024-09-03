class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        Integer lenT = t.length();
        Integer lenP = p.length();

        for(int i = 0; i < lenT; i++) {
            if(i >= lenT - lenP + 1) {
                break;
            }

            String partialStr = t.substring(i, i + lenP);
            if(Long.parseLong(partialStr) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}