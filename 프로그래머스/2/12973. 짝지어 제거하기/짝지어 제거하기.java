import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 스택이 비어있지 않고, top에 있는 문자와 현재 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝 제거
            } else {
                stack.push(c); // 아니면 스택에 추가
            }
        }
        
        // 스택이 비어있으면 모두 짝지어 제거된 것
        return stack.isEmpty() ? 1 : 0;
    }
}

