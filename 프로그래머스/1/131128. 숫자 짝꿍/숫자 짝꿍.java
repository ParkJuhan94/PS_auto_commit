import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 각 숫자의 빈도수 배열
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // X와 Y의 각 숫자의 빈도를 계산
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }

        // 결과를 조합할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 높은 숫자부터 차례대로 짝꿍 찾기
        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(xCount[i], yCount[i]);
            if (minCount > 0) {
                result.append(String.valueOf(i).repeat(minCount));
            }
        }

        // 결과 확인
        if (result.length() == 0) {
            return "-1"; // 짝꿍이 없는 경우
        }
        if (result.charAt(0) == '0') {
            return "0"; // 짝꿍이 0으로만 이루어진 경우
        }

        return result.toString();
    }
}
