import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Car> queue = new ArrayDeque<>();
        int index = 1;
        int time = 2;
        int nowWeight = truck_weights[0];
        int len = bridge_length - 1;
        
        while(len-- > 0) {
            queue.offer(new Car(0, -1));
        }
        queue.offer(new Car(truck_weights[0], 0));
        
        // 1초마다 다리에서는 앞으로 전진
        // 현재 다리에 무게가 버틸 수 있다면 다음 차 진입
        // 아니면 0 지입
        
        while(true) {   // 더이상 다리에 차량이 없는 경우
            Car outCar = queue.poll();
            nowWeight -= outCar.weight;
            if(outCar.idx == truck_weights.length - 1) {
                break;
            }
            if(index < truck_weights.length) {
                if(nowWeight + truck_weights[index] <= weight) {
                    queue.offer(new Car(truck_weights[index], index));
                    nowWeight += truck_weights[index];
                    index++;
                }
                else {
                    queue.offer(new Car(0, -1));
                }
            }
            else {
                queue.offer(new Car(0, -1));
            }

            time++;
        }
        

        // 모든 트럭이 다리를 건너려면 최소 몇 초
        return time;
    }
    static class Car {
        int weight, idx;
        
        public Car(int weight, int idx) {
            this.weight=weight;
            this.idx=idx;
        }
    }
}