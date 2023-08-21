//package Programmers.Level_3.불량사용자;

import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answer;
    static String[] user_id;
    static String[] banned_id;
    static LinkedHashSet<String> tmpBanList = new LinkedHashSet<>();    // 추가한 순서를 보장

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        Solution.user_id = user_id;
        Solution.banned_id = banned_id;

        dfs();

        return answer.size();
    }


    private static void dfs() {
        if (tmpBanList.size() == banned_id.length) {

            if (isBanList()) {
                answer.add(new HashSet<>(tmpBanList));
            }
            return;
        }

        // 완탐
        for (String userId : user_id) {
            if (tmpBanList.add(userId)) {
                dfs();
                tmpBanList.remove(userId);
            }
        }
    }

    // 불량사용자 리스트에 맞는지 확인
    private static boolean isBanList() {
        int idx = 0;

        for (String userID : tmpBanList) {
            String banID = banned_id[idx++];

            if (userID.length() != banID.length()) {
                return false;
            }

            for (int i = 0; i < banID.length(); i++) {
                if (banID.charAt(i) == '*') {
                    continue;
                }
                if (userID.charAt(i) != banID.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}