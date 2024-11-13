import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<bridge_length; i++) {
            queue.offer(0);
        }
        int currentWeight = 0;
        int index = 0;
        while(!queue.isEmpty()) {
            currentWeight -= queue.poll(); //앞에 있는거 빼기
            
            if(index < truck_weights.length) {
                if(currentWeight + truck_weights[index] <= weight) {
                    currentWeight += truck_weights[index];  //다리에 있는 차량의 누적 무게
                    queue.offer(truck_weights[index]);
                    index++;
                }
                else {  //하중을 이길 수 없음 -> 같이 못건넘
                    queue.offer(0);
                }
            }
            
            answer++;
        }
        return answer;
    }
}