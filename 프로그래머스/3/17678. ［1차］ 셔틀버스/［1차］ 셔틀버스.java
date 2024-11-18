import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] arriveTime = new int[timetable.length];
        
        for(int i=0; i<timetable.length; i++) {
            String[] time = timetable[i].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            arriveTime[i] = hour * 60 + min;
        }
        Arrays.sort(arriveTime);    //도착시간 오름차순 정렬

        int startTime = 9 * 60; //셔틀 출발시간: 9시
        int index = 0;  //탑승 대기 인덱스
        int lastTime = 0;
        
        for(int cnt=0; cnt<n; cnt++) {
            int people = 0; //현재 셔틀 탑승 인원
            
            //탑승
            while(index < arriveTime.length && arriveTime[index] <= startTime && people < m) {
                people++;
                index++;
            }
            //막차일 경우
            if(cnt == n - 1) {  
                if(people == m) {  //꽉 찼다면
                    lastTime = arriveTime[index - 1] - 1;
                }
                else {  //자리 남아있다면 -> 셔틀 도착시간
                    lastTime = startTime;
                }
            }
            startTime += t; //다음 셔틀 배차
        }
        return String.format("%02d:%02d", lastTime / 60, lastTime % 60);
    }
}