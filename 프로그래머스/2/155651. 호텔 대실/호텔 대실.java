import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        //10분 청소
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for(int i=0; i<book_time.length; i++) {
            String[] b = book_time[i];
            int start = makeMinute(b[0]);
            int end = makeMinute(b[1]);
            
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end + 10);
        }

        // 최소한의 객실 수
        return pq.size();
    }
    private static int makeMinute(String time) {
        String[] start = time.split(":");
        int startH = Integer.parseInt(start[0])*60;
        int startM = Integer.parseInt(start[1]);
        
        return startH + startM;
    }
}