import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";        
        long[] xArr = new long[10];
        long[] yArr = new long[10];
        
        for(char c : X.toCharArray()) {
            xArr[c - '0']++;
        }
        for(char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<10; i++) {
            if(xArr[i] > 0 && yArr[i] > 0) {
                long cnt = Math.min(xArr[i], yArr[i]);
                while(cnt-- > 0) {
                    pq.offer((long)i);
                }
                
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            long now = pq.poll();
            sb.append(now);
        }
        if(sb.length() == 0) {
            return "-1";
        }
        // long result = Long.parseLong(sb.toString());
        String result = sb.toString();
        // StringBuilder temp = new Stringbuilder(result);
        int index = 0;
        while(index < sb.length() - 1) {
            if(sb.charAt(index) != '0') {
                break;
            }
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}