import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder resSb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if('0' <= c && c <= '9'){
                resSb.append(c);
            }else{
                sb.append(c);
                if(map.containsKey(sb.toString())){
                    resSb.append(map.get(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }

        answer = Integer.parseInt(resSb.toString());

        return answer;
    }
}