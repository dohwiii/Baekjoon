import java.util.*;

class Solution {
    static int[] arriveTime;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        arriveTime = new int[timetable.length];
        
        for(int i=0; i<timetable.length; i++) {
            String[] arr = timetable[i].split(":");
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);
            arriveTime[i] = hour * 60 + min;
        }
        Arrays.sort(arriveTime);

        int cnt = 0;    //셔틀 도착 횟수 카운트
        int startTime = 9 * 60; //9시
        int index = 0;
        List<Integer> together = new ArrayList<>();
        int lastIndex = 0;
        
        while(true) {
            if(cnt > n) {   //셔틀 운행 끝
                break;
            }
            int people = 0; //탑승 인원
            // together = new ArrayList<>();
            
            while(index < arriveTime.length) {
                int now = arriveTime[index];
                if(startTime < now) {
                    break;
                }
                if(people >= m) {
                    break;
                }
                //탑승
                together.add(index);
                people++;
                index++;
            }
            if(cnt == n - 1) {  //막차
                if(people >= m) {  //꽉 찼다면
                    lastIndex = index - 1;
                    int lastTime = arriveTime[index - 1];
                    lastTime = lastTime - 1;
                    int hour = lastTime / 60;
                    int min = lastTime % 60;
                    answer = makeTimeFormat(hour+"", min+"");
                }
                else {  //자리 남아있다면
                    answer = makeTimeFormat((startTime / 60)+"", (startTime % 60)+"");
                }
                break;
            }
            cnt++;
            startTime += t; //다음 배차
        }
        
        return answer;
    }
    public String makeTimeFormat(String hour, String min) {
        StringBuilder sb = new StringBuilder();
        if(hour.length() < 2) {
            sb.append("0");
        }
        sb.append(hour).append(":");
        if(min.length() < 2) {
            sb.append("0");
        }
        sb.append(min);
        return sb.toString();
    }
}