import java.util.Stack;

class Solution {
    int N;
    int[][] board;

    public int solution(int[][] board, int[] moves) {
        N = board.length;
        this.board = board;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++)
        {
            int cur = getTop(moves[i] - 1);

            if(cur == 0){
                continue;
            }

            if(stack.isEmpty()){
                stack.push(cur);
            }else{
                if(stack.peek() == cur){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(cur);
                }
            }
        }

        return answer;
    }

    int getTop(int col) {
        int res = 0;    // 집어 올린게 없으면 0(빈칸)을 반환

        for(int i = 0; i < N; i++){
            if(board[i][col] != 0){
                res = board[i][col];
                board[i][col] = 0;
                break;
            }
        }

        return res;
    }
}