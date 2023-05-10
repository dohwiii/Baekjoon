import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        int right = 0;
        int left = 0;
        
        for(int i=0; i < s.length(); i++)
        {
            queue.add(s.charAt(i));
        }
        if(queue.peek() == ')')
        {
            return false;
        }
            
        while(!queue.isEmpty())
        {
            char now = queue.poll();
            if(now == '(')
                right++;
            else if(now == ')')
                left++;
            if(right < left)
                return false;
        }
        if(right == left)
            return true;
        return false;
    }
}