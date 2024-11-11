import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE; // 위쪽 좌표의 최소값
        int luy = Integer.MAX_VALUE; // 왼쪽 좌표의 최소값
        int rdx = Integer.MIN_VALUE; // 아래쪽 좌표의 최대값
        int rdy = Integer.MIN_VALUE; // 오른쪽 좌표의 최대값

        // 바탕화면을 탐색하며 파일의 위치를 찾음
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }

        // 드래그의 시작점과 끝점을 반환
        return new int[]{lux, luy, rdx, rdy};
    }
}
