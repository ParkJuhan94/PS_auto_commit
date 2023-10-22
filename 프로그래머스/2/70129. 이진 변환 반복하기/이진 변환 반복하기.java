class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int countZero = 0;
        
        while(!s.equals("1")) {
            int befLen = s.length();
            s = s.replace("0","");
            cnt++;
            
            countZero += (befLen - s.length());
            s = Integer.toBinaryString(s.length());
        }
        
        return new int[]{cnt, countZero};
    }
}