import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>(bridge_length);
        for(int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }
        int totalW = 0; // 현재 다리에 있는 무게
        int time = 0;
        int index = 0;  // 트럭 순서 인덱스
        
        while(!queue.isEmpty()) {
            int first = queue.poll();   // 맨 앞 트럭 뺌
            totalW -= first;
            time++;         // 초 증가

            if(index < truck_weights.length) {
                if(totalW + truck_weights[index] <= weight) {
                    queue.offer(truck_weights[index]);  // 현재 index 트럭 탑승
                    totalW += truck_weights[index];
                    index++;    // 다음 트럭
                }
                else {  // 다음 트럭을 무게 초과로 인해 못지나감
                    queue.offer(0);
                }
            }
        }      
        
        return time;
    }
}