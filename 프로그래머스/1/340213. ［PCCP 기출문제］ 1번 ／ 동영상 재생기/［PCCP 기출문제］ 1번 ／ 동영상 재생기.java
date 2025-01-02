import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int hour = Integer.parseInt(pos.substring(0, 2));
        int min = Integer.parseInt(pos.substring(3, 5));
        int nowPos = hour*60 + min;
        
        int osHour = Integer.parseInt(op_start.substring(0, 2));
        int osMin = Integer.parseInt(op_start.substring(3, 5));
        int oeHour = Integer.parseInt(op_end.substring(0, 2));
        int oeMin = Integer.parseInt(op_end.substring(3, 5));
        int oe = oeHour*60 + oeMin;
        int os = osHour*60 + osMin;
        int total = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3, 5));
        
        for(int i=0; i<commands.length; i++) {
            String command = commands[i];   //명령어
            
            if(nowPos >= os && nowPos <= oe) {
                nowPos = oe;
            }
            
            if(command.equals("next")) {
                nowPos = Math.min(total, nowPos + 10);
            }
            else {  //prev
                nowPos = Math.max(0, nowPos-10);
            }
        }
        if(nowPos >= os && nowPos <= oe) {
            nowPos = oe;
        }
        int ahour = nowPos/60;
        int amin = nowPos%60;
        answer = String.format("%02d:%02d", ahour, amin);
        return answer;
    }
}