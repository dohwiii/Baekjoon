import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        
        for(String c : cards1) {
            queue1.offer(c);
        }
        for(String c : cards2) {
            queue2.offer(c);
        }
        for(String g : goal) {
            boolean isPossible = false;
            if(!queue1.isEmpty() && queue1.peek().equals(g)) {
                queue1.poll();
                isPossible = true;
            }
            else if(!queue2.isEmpty() && queue2.peek().equals(g)) {
                queue2.poll();
                isPossible = true;
            }
            if(!isPossible) {
                return "No";
            }
        }
         
        return "Yes";
    }
}