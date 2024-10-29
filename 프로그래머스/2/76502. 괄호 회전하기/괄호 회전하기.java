import java.util.*;

class Solution {
    static Queue<Character> queue = new ArrayDeque<>();
    
    public int solution(String s) {
        int answer = 0;
  
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) { 
            if (isRight()) {     
                answer++;
            }
            // 회전: 첫 번째 문자를 뒤로 보냄
            char now = queue.poll();
            queue.offer(now);
        }
        
        return answer;
    }

    public boolean isRight() {
        Stack<Character> stack = new Stack<>();
        
        for (char c : queue) {
            // 열린 괄호는 스택에 넣음
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 닫힌 괄호일 경우
                if (stack.isEmpty()) {
                    return false;  // 짝이 맞지 않음
                }
                char top = stack.pop();
                
                // 스택에서 꺼낸 열린 괄호와 닫힌 괄호가 짝이 맞는지 확인
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        // 모든 열린 괄호가 짝이 맞아 스택이 비어 있어야 올바른 괄호열임
        return stack.isEmpty();
    }
}
