class Solution {
    public int[][] solution(int n) {
        int[][] matrix = new int[n][n]; // 나선형 배열을 담을 2차원 배열
        int num = 1;                    // 배열에 채워질 숫자 (1부터 n^2까지)
        int row = 0, col = 0;           // 현재 행과 열의 위치
        int direction = 0;              // 이동 방향 (0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위)
        int[] dr = {0, 1, 0, -1};       // 행 이동 배열 (오른쪽 -> 아래 -> 왼쪽 -> 위)
        int[] dc = {1, 0, -1, 0};       // 열 이동 배열 (오른쪽 -> 아래 -> 왼쪽 -> 위)
        
        for(int i = 0; i < n * n; i++) {
            matrix[row][col] = num;
            num++;
            
            // 다음 row, col 지정    
            row = row + dr[direction];
            col = col + dc[direction];
            
            // 방향 바꿔야 한다면 방금 이동을 되돌리고 다시 이동
            if(row < 0 || n <= row || col < 0 || n <= col || matrix[row][col] != 0) {
                row = row - dr[direction];
                col = col - dc[direction];
                direction = (direction + 1) % 4;
                row = row + dr[direction];
                col = col + dc[direction];
            }
        }
        
        return matrix;
    }
}