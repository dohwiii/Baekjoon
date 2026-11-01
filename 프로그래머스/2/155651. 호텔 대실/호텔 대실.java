import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        //10분 청소
        PriorityQueue<RoomTime> pq = new PriorityQueue<>();
        
        int roomNum = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for(int i=0; i<book_time.length; i++) {
            String[] b = book_time[i];
            int start = makeMinute(b[0]);
            int end = makeMinute(b[1]);
            
            if(pq.isEmpty()) {  // 방 없다면
                roomNum++;
                pq.offer(new RoomTime(roomNum, end + 10));
            }
            else {
                RoomTime r = pq.peek();
                if(r.time <= start) {   // 방 사용 가능
                    pq.poll();
                    pq.offer(new RoomTime(r.rNum, end + 10));
                }
                else {  // 사용가능한 방 없음
                    roomNum++;
                    pq.offer(new RoomTime(roomNum, end + 10));
                }
            }
        }
        
        
        
        
        // 최소한의 객실 수
        return roomNum;
    }
    private static int makeMinute(String time) {
        String[] start = time.split(":");
        int startH = Integer.parseInt(start[0])*60;
        int startM = Integer.parseInt(start[1]);
        
        return startH + startM;
    }
    static class RoomTime implements Comparable<RoomTime> {
        int rNum, time;
        
        public RoomTime(int rNum, int time) {
            this.rNum=rNum;
            this.time=time;
        }
        
        @Override
        public int compareTo(RoomTime r) {
            return this.time-r.time;
        }
    }
}