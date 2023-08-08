import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = id_list.length;
        int[] answer = new int[N];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(id_list[i], 0);
        }

        // 신고 중복 제거
        Set<String> set = new HashSet<>();
        for(int i = 0; i < report.length; i++){
            set.add(report[i]);
        }
        report = new String[set.size()];
        int idx = 0;
        for(String str : set){
            report[idx++] = str;
        
        }

        // 신고 카운팅

        for(String report_ : report){
            String[] inputArr = report_.split(" ");
            String key = inputArr[0];
            String value = inputArr[1];

            map.put(value, map.get(value) + 1);
        }

        // 정지ID
        ArrayList<String> banList = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) >= k){
                banList.add(key);
            }
        }

        // answer 만들기
        HashMap<String, Integer> answerMap = new HashMap<>();
        for(String report_ : report){
            String[] inputArr = report_.split(" ");
            String key = inputArr[0];
            String value = inputArr[1];

            if(banList.contains(value)){
                if(answerMap.containsKey(key)){
                    answerMap.put(key, answerMap.get(key) + 1);
                }else{
                    answerMap.put(key, 1);
                }
            }
        }

        idx = 0;
        for(int i = 0; i < N; i++){
            if(answerMap.containsKey(id_list[i])){
                answer[idx++] = answerMap.get(id_list[i]);
            }else{
                answer[idx++] = 0;
            }
        }

        return answer;
    }
}