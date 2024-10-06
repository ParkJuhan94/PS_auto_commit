import java.util.*;

class Solution {
    public String[] solution(String my_string) {
         // 공백을 기준으로 단어를 나누지만, 빈 문자열을 제외하는 방법 사용
        String[] temp = my_string.split(" ");
        // 빈 문자열을 제거하고 실제 단어만 저장할 리스트 생성
        List<String> resultList = new ArrayList<>();
        
        // 빈 문자열이 아닌 단어들만 리스트에 추가
        for (String word : temp) {
            if (!word.isEmpty()) {
                resultList.add(word);
            }
        }
        
         // 리스트를 배열로 변환하여 반환
        String[] result = new String[resultList.size()];
        return resultList.toArray(result);
    }
}