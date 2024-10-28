import java.util.*;

class Solution {
public static int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int x = 0, y = 0;
        
        // 시작 위치 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        // 방향별 이동 좌표 설정
        int[][] directions = {
            {'N', -1, 0}, // 북쪽
            {'S', 1, 0},  // 남쪽
            {'W', 0, -1}, // 서쪽
            {'E', 0, 1}   // 동쪽
        };
        
        // 명령 수행
        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            char dir = splitRoute[0].charAt(0);
            int dist = Integer.parseInt(splitRoute[1]);
            int dx = 0, dy = 0;

            // 방향 설정
            for (int[] direction : directions) {
                if (direction[0] == dir) {
                    dx = direction[1];
                    dy = direction[2];
                    break;
                }
            }

            // 이동 가능 여부 확인
            boolean canMove = true;
            for (int step = 1; step <= dist; step++) {
                int nx = x + dx * step;
                int ny = y + dy * step;

                // 공원 범위 밖이거나 장애물인 경우
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 이동 가능하면 위치 업데이트
            if (canMove) {
                x += dx * dist;
                y += dy * dist;
            }
        }
        
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};
        int[] result = solution(park, routes);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}