import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> scoreList = new ArrayList<>();

        int tmpScore = 0;

        for(int i = 0; i < dartResult.length(); i++){
            char cur = dartResult.charAt(i);

            if('0' <= cur && cur <= '9')
            {
                if(tmpScore != 0){
                    scoreList.add(tmpScore);
                    answer += tmpScore;
                }
                // 10 일 경우 생각
                char next = dartResult.charAt(i + 1);
                if(next == '0'){
                    i++;
                    tmpScore = 10;
                }else{
                    tmpScore = cur - '0';
                }
            }else if(cur == 'D')
            {
                tmpScore *= tmpScore;
            }else if(cur == 'T')
            {
                int multi = tmpScore;
                tmpScore *= multi;
                tmpScore *= multi;
            }else if(cur == '*')
            {
                if(scoreList.size() == 0){
                    tmpScore *= 2;
                }else{
                    answer += scoreList.get(scoreList.size() - 1);
                    tmpScore *= 2;
                }
            }else if(cur == '#')
            {
                tmpScore *= -1;
            }
        }

        answer += tmpScore;

        return answer;
    }
}