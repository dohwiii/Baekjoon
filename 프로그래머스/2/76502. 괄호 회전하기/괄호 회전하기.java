import java.util.*;
class Solution {
    static Queue<Character> queue = new ArrayDeque<>();
    
    public int solution(String s) {
        int answer = 0;
  
        for(int i=0; i<s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        int cnt = 1;
        while(cnt <= s.length()) { 
            if(isRight()) {     
                answer++;
            }
            char now = queue.poll();
            queue.offer(now);
            cnt++;
        }
        
        return answer;
    }
    public boolean isRight() {
        Stack<Character> stack = new Stack<>();
        
        for(char c : queue) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else {  //닫힌 괄호
                if(stack.isEmpty()) {
                    return false;
                }
                if(c == ']') {
                    if(stack.peek() == '(' || stack.peek() == '{') {
                        return false;
                    }
                    else {
                        stack.pop();
                    }
                }
                if(c == '}') {
                    if(stack.peek() == '(' || stack.peek() == '[') {
                        return false;
                    }
                    else {
                        stack.pop();
                    }
                }
                if(c == ')') {
                    if(stack.peek() == '[' || stack.peek() == '{') {
                        return false;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
                
        }
        return stack.isEmpty();
        
    }
    
    
    
    
//     public boolean isRight() {
//         Stack<Character> stack1 = new Stack<>();    //()
//         Stack<Character> stack2 = new Stack<>();    //[]
//         Stack<Character> stack3 = new Stack<>();    //{}
        
//         for(char c : queue) {
//             if(c == '(') {
//                 stack1.push('(');
//             }
//             else if(c == ')') {
//                 if(stack1.isEmpty()) {  //열린 괄호 없을 때
//                     return false;
//                 }
//                 if(!stack2.isEmpty() || !stack3.isEmpty()) {
//                     return false;
//                 }
//                 stack1.pop();
//             }
            
//             if(c == '[') {
//                 stack2.push('[');
//             }
//             else if(c == ']') {
//                 if(stack2.isEmpty()) {
//                     return false;
//                 }
//                 if(!stack1.isEmpty() || !stack3.isEmpty()) {  //다른 열린 괄호들이 사이에 껴있다면
//                     return false;
//                 }
//                 stack2.pop();
//             }
            
//             if(c == '{') {
//                 stack3.push('{');
//             }
//             else if(c == '}') {
//                 if(stack3.isEmpty()) {
//                     return false;
//                 }
//                 if(!stack1.isEmpty() || !stack2.isEmpty()) {  //다른 열린 괄호들이 사이에 껴있다면
//                     return false;
//                 }
//                 stack3.pop();
//             }
//         }
//         return stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty();
//     }
    
}