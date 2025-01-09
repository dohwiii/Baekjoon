import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            String temp = sb.toString();
            char c = s.charAt(i);
            
            if(temp.length() == 0 || !temp.contains(String.valueOf(c))) {
                answer[i] = -1;
            }
            else {
                int cIndex = temp.lastIndexOf(c, i);
                answer[i] = i - cIndex;
            }
            sb.append(c);
        }
        
        return answer;
    }
}