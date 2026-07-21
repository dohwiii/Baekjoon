import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            long a = (long) s;
            pq.offer(a);
        }
        boolean isPossible = false;
        int cnt = 0;    // 섞은 횟수
        
        while(!pq.isEmpty()) {
            if(pq.peek() >= K) {        
                isPossible = true;
                break;
            }
            if(pq.size() < 2) {
                break;
            }
            long smaller = pq.poll();
            long larger = pq.poll();
            long mix = smaller + larger * 2;
            pq.offer(mix);
            cnt++;  // 섞기
            
        }
        if(isPossible) {
            return cnt;
        }
        
        return -1;
    }
}