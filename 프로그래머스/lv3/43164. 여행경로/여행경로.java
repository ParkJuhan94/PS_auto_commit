import java.util.*;

class Solution {
    int N;
    boolean end = false;
    Deque<String> answerQ = new LinkedList<>();
    HashMap<String, Queue<String>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {

        N = tickets.length;

        // 연결 정보 만들기
        Arrays.sort(tickets, (a, b) -> {
            return a[1].compareTo(b[1]);
        });

        for(int i = 0; i < tickets.length; i++){
            String s = tickets[i][0];
            String e = tickets[i][1];

            if(!map.containsKey(s)){
                Queue<String> q = new LinkedList<>();
                q.add(e);
                map.put(s, q);
            }else{
                map.get(s).add(e);
            }
        }

        answerQ.add("ICN");
        dfs(0, "ICN");

        return answerQ.toArray(new String[0]);
    }

    void dfs(int depth, String cur) {
        if(depth == N){ // 주어진 항공권은 모두 사용해야 합니다.
            end = true;
            return;
        }

        if(!map.containsKey(cur)) return;

        for(int i = 0; i < map.get(cur).size(); i++){
            String next = map.get(cur).poll();

            answerQ.add(next);
            dfs(depth + 1, next);

            if(!end) {
                answerQ.pollLast();
                map.get(cur).add(next);
            }else{
                return;
            }
        }
        
//        while(!map.get(cur).isEmpty()){
//            String next = map.get(cur).poll();
//
//            answerQ.add(next);
//            dfs(depth + 1, next);
//
//            if(!end) {
//                answerQ.pollLast();
//                map.get(cur).add(next);
//            }else{
//                return;
//            }
//        }

    }
}