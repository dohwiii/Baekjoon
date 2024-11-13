import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        while(pq.size() > 1 && pq.peek() < K) {
            int least = pq.poll();    //가장 맵지 않음
            int second = pq.poll(); //두번째로 안매움
            int newScoville = least + 2 * second;
            pq.offer(newScoville);
            answer++;
        }
        
        return pq.peek() >= K ? answer : -1;
    }
} 