import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        int[] todayArr = new int[3];
        todayArr[0] = Integer.parseInt(today.substring(0, 4));
        todayArr[1] = Integer.parseInt(today.substring(5, 7));
        todayArr[2] = Integer.parseInt(today.substring(8, 10));
        int dateToday = todayArr[0] * 12 * 28 + todayArr[1] * 28 + todayArr[2];

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++){
            String cur = privacies[i];
            int dateCur =  Integer.parseInt(cur.substring(0, 4)) * 12 * 28
                    + Integer.parseInt(cur.substring(5, 7)) * 28 + Integer.parseInt(cur.substring(8, 10));

            dateCur += map.get(privacies[i].substring(11)) * 28;

            if(dateCur <= dateToday){
//                System.out.println("cur.substring(0,4)  = " + cur.substring(0, 4));
//                System.out.println("cur.substring(5,7)  = " + Integer.parseInt(cur.substring(5, 7)));
//                System.out.println("cur.substring(8,10)  = " + cur.substring(8, 10));
                ansList.add(i + 1);
            }
        }

        int[] answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}