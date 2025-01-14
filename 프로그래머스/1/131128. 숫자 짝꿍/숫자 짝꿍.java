import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";        
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(char c : X.toCharArray()) {
            xArr[c - '0']++;
        }
        for(char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=9; i>=0; i--) {
            if(xArr[i] > 0 && yArr[i] > 0) {
                int cnt = Math.min(xArr[i], yArr[i]);
                while(cnt-- > 0) {
                    sb.append(i);
                }
                
            }
        }
        if(sb.length() == 0) {
            return "-1";
        }
        String result = sb.toString();
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