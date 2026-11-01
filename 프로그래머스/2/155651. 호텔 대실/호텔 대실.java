import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] inTime = new int[book_time.length];
        int[] available = new int[book_time.length];
        
        for(int i=0; i<book_time.length; i++) {
            int start = makeMinute(book_time[i][0]);
            int end = makeMinute(book_time[i][1]);
            inTime[i] = start;
            available[i] = end + 10;
        }
        Arrays.sort(inTime);
        Arrays.sort(available);
        int i=0, j=0;
        
        while(i<book_time.length && j<book_time.length) {
            if(inTime[i]  >= available[j]) {
                i++;
                j++;
            }
            else {
                i++;
                answer++;
            }
        }
        
        
        
        return answer;
    }
    private static int makeMinute(String time) {
        String[] start = time.split(":");
        int startH = Integer.parseInt(start[0])*60;
        int startM = Integer.parseInt(start[1]);
        
        return startH + startM;
    }
}