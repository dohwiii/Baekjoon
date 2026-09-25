import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] strArr = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        stack.push(strArr[0]);
        int remove = 0;
        for(int i=1; i<strArr.length; i++) {
            while(!stack.isEmpty() && remove < k) {
                if(stack.peek() < strArr[i]) {
                    remove++;
                    stack.pop();
                }
                else {
                    break;
                }
            }
            stack.push(strArr[i]);
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        answer = sb.toString();
        if(sb.toString().length() > strArr.length - k) {
            answer = sb.substring(0, strArr.length - k);
        }
        // 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태(number - k 길이)
        return answer;
    }
}