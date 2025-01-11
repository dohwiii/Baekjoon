import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            int per = food[i] / 2;
            while(per-- > 0) {
                sb.append(i);
            }
        }
        String original = sb.toString();
        String s = sb.reverse().toString();
        sb.setLength(0);
        sb.append(original);
        sb.append(0);
        sb.append(s);
        return sb.toString();
    }
}