import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(String p) {
        String answer = "";
        String str = p;
        if(isRightSentence(p)) {
            return p;
        }
        splitStr(p);
        
        return sb.toString();
    }
    
    public void splitStr(String str) {
        if(str.isEmpty()) {
            return;
        }
        int left = 0;
        int right = 0;
        int index = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if(left == right) {
                index = i;
                break;
            }
        }
        index = index + 1;
        String u = str.substring(0, index);
        String v = str.substring(index, str.length());
        
        if(isRightSentence(u)) {
            sb.append(u);
            splitStr(v);
        }
        else {
            sb.append("(");
            splitStr(v);
            sb.append(")");
            
            for(int i=1; i<u.length() - 1; i++) {
                if(u.charAt(i) == '(') {
                    sb.append(")");
                }
                else {
                    sb.append("(");
                }
            }
        }
    }
    //올바른 괄호 문자열인지
    public boolean isRightSentence(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();    // '(' 빼기
                }
                else {
                    return false;
                }
            }        
        }
        return stack.isEmpty();
    }
}