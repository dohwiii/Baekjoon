import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        StringBuilder sb = new StringBuilder();
        sb.append(t.substring(0, length));
        long now = Long.parseLong(sb.toString());
        if(now <= Long.parseLong(p)) {
            answer++;
        }
            
        for(int i=length; i<t.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(t.charAt(i));
            now = Long.parseLong(sb.toString());
            
            if(now <= Long.parseLong(p)) {                
                answer++;
            }
        }
        
        return answer;
    }
}