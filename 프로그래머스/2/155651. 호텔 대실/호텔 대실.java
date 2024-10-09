import java.util.*;
import java.time.*;

class Solution {    
    public int solution(String[][] book_time) {
        int answer = 0;
        int room = 0;
        int[][] times = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            times[i][0] = convertToMinutes(book_time[i][0]);    //대실 시작시간
            times[i][1] = convertToMinutes(book_time[i][1]) + 10;   //대실 종료시간 + 10분 청소
        }
        
        //예약 시간을 시작 시각을 기준으로 정렬
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(int[] time : times) {
            int start = time[0];
            int end = time[1];
            
            if(!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }
            rooms.offer(end);
        }
        return rooms.size();
    }
    public int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hour*60 + min;
    }
}