class Solution {
    public static int[] dr = {0, -1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dc = {0, -1, 0, 1, 1, -1, -1, 0, 1};
    
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                boolean isPossible = true;
                
                for(int k = 0; k < 9; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                
                    if(0 <= nr && nr < board.length && 0 <= nc && nc < board.length && board[nr][nc] == 1) {
                        isPossible = false;
                        break;
                    }                   
                }
                
                if(isPossible) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}