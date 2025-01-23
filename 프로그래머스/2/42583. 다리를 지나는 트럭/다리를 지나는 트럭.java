import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }
        int time = 0;
        int totalWeight = 0;
        int index = 0;
        
        while(!queue.isEmpty()) {
            totalWeight -= queue.poll();   //차 내림
            
            if(index < truck_weights.length) {
                int w = truck_weights[index];
                
                if(totalWeight + w <= weight) {
                    queue.offer(w);
                    totalWeight += w;
                    index++;    //다음 트럭
                }
                else {
                    queue.offer(0);
                }
            }
            time++;
        } 
        return time;
    }
}