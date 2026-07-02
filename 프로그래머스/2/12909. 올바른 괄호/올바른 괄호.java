import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(char c: arr) {
            if(c == '(') {
                stack.push(c);
            }
            else {  // ')'
                if(!stack.isEmpty()) {
                    char now = stack.pop();
                    if(now != '(') {
                        return false;
                    }
                }
                else {
                    return false;
                }
                
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
       
        return true;
    }
}