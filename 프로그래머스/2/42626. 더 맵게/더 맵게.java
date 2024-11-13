import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        boolean isPossible = false;
        while(!pq.isEmpty()) {
            int now = pq.poll();    //가장 맵지 않음
            if(now >= K) {
                isPossible = true;
                break;
            }
            if(!pq.isEmpty()) {
                int next = pq.poll();   //두번째로 안매운 지수
                int result = now + 2 * next;
                pq.offer(result);
                answer++;
            }
        }
        if(!isPossible) {
            return -1;
        }
        
        return answer;
    }
} 