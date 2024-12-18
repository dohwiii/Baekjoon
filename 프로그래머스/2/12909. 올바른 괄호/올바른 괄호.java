import java.util.*;

class Solution {
    boolean solution(String s) {
        int N = s.length();
        Queue<Character> queue = new ArrayDeque<>();
        
        if(s.charAt(0) != '(') {
            return false;
        }
        for(int i=0; i<N; i++) {
            char c = s.charAt(i);
            queue.offer(c);
        }
        int countA = 0;
        int countB = 0;
        
        while(!queue.isEmpty()) {
            char now = queue.poll();
            if(now == '(') {
                countA++;
            }
            else if(now == ')') {
                countB++;
            }
            if(countA < countB) {   //닫는괄호(')')가 여는괄호('(')보다 많은 경우
                return false;
            }
        
        }
        if(countA == countB) {
            return true;
        }
        return false;
    }
}