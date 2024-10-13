import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++) {
            queue.offer(prices[i]);
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int cnt = 0;
            int max = 0;
            
            if(!queue.isEmpty()) {
                for(int next : queue) {
                    if(now <= next) {
                        cnt++;
                    }
                    else {
                        cnt++;
                        break;
                    }
                }
            }
            
            answer[index++] = cnt;
        }
        return answer;
    }
} 