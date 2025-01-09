import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0;
        
        for(int s : score) {
            pq.offer(s);
            
            if(pq.size() > k) {
                pq.poll();
                answer[day++] = pq.peek();
            }
            else {
                answer[day++] = pq.peek();
            }
        }
        return answer;
    }
}