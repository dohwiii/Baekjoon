import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);   // s+s
        
        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String sub = sb.substring(i, i+s.length()); // 문자열 자르기
            char[] arr = sub.toCharArray();
            boolean isPossible = true;

            for(int k=0; k<arr.length; k++) {
                if(arr[k] == '(' || arr[k] == '{' || arr[k] == '[') {   // 열린 괄호 -> stack 추가
                    stack.push(arr[k]);
                }
                else {  // 닫힌 괄호 
                    if(stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    char open = stack.pop();

                    if(arr[k] == ')') {
                        if(open != '(') {
                            isPossible = false;
                            break;
                        }
                    }
                    else if(arr[k] == '}') {
                        if(open != '{') {
                            isPossible = false;
                            break;
                        }
                    } 
                    else if(arr[k] == ']') {
                        if(open != '[') {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            if(isPossible && stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}