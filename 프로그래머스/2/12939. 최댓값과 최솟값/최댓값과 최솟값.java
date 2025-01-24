import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<sArr.length; i++) {
            int num = Integer.parseInt(sArr[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " "+ max;
    }
}