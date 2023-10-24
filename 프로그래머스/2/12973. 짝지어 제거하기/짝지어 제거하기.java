import java.util.*;

class Solution
{
    public int solution(String s) {
    if (isPossible(s)) {
        return 1;
    } else {
        return 0;
    }
}

    public boolean isPossible(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}