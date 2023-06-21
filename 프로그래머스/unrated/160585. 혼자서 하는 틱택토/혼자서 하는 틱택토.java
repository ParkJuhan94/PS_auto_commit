class Solution {
    public int numLine(String[] board, char target){
        // target 역변환 시켜줌. 연산 편하게
        target = (target == 'O') ? 'X' : 'O';
        int flag = 0;
        int cnt = 0;

        // map 으로 만들어서 연산 편하게
        char[][] map = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        // O 라인 찾기
        // 1. 가로
        for(int i = 0; i < 3; i++){
            flag = 0;
            for(int j = 0; j < 3; j++){
                if(map[i][j] == target || map[i][j] == '.'){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) cnt++;
        }

        // 2. 세로
        for(int i = 0; i < 3; i++){
            flag = 0;
            for(int j = 0; j < 3; j++){
                if(map[j][i] == target || map[j][i] == '.'){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) cnt++;
        }

        // 3. 대각선
        flag = 0;
        for(int i = 0; i < 3; i++){
            if(map[i][i] == target || map[i][i] == '.')
                flag = 1;
        }
        if(flag == 0) cnt++;

        flag = 0;
        for(int i = 0; i < 3; i++){
            if(map[i][2 - i] == target || map[i][2 - i] == '.')
                flag = 1;
        }
        if(flag == 0) cnt++;

        return  cnt;
    }

    public int solution(String[] board) {

        // (O 갯수) < (X 갯수) 일 때
        // (O 갯수) 가 (X 갯수) 보다 2개 이상 많을 때
        int numO = 0;
        int numX = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'O'){
                    numO++;
                }else if (board[i].charAt(j) == 'X'){
                    numX++;
                }
            }
        }

        if(numX > numO || numO - numX >= 2){
            return 0;
        }

        // 정답 라인의 갯수가 2 이하여야 한다!!! (센터에 놓았을 때 라인 두 개로 승리 가능)
        int numLine = numLine(board, 'O') + numLine(board, 'X');

        if(numLine >= 3){
            return 0;
        }

        // 정답 라인의 갯수가 2인데, 2개가 같은 종류여야 해
        if(numLine == 2){
            if((numLine(board, 'O') == 1)){
                return 0;
            }

            if((numLine(board, 'X') == 1)){
                return 0;
            }
        }

        // X 라인이 1개 있으면 둘 갯수 같아야 해
        if(numLine(board, 'X') == 1 && !(numO == numX)){
            return 0;
        }

        // O 라인이 1개 있으면 O 갯수가 X 갯수보다 1 커야 해
        if(numLine(board, 'O') == 1 && !(numO == numX + 1)){
            return 0;
        }

        return 1;
    }
}