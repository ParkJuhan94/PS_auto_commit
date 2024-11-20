import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);

            // 스택의 마지막 4개가 [1, 2, 3, 1]인지 확인
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 && 
                    stack.get(size - 3) == 2 && 
                    stack.get(size - 2) == 3 && 
                    stack.get(size - 1) == 1) {
                    
                    // 햄버거 완성 시 4개 제거
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
