import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 다리 위 트럭 상태 (큐)
        int totalWeightOnBridge = 0; // 다리 위 트럭의 총 무게
        int time = 0; // 경과 시간
        int index = 0; // 대기 중인 트럭 배열의 인덱스

        // 다리 길이만큼 큐를 0으로 채워서 초기화 (트럭이 없는 상태)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++; // 시간 경과

            // 다리 맨 앞 트럭이 나가는 시간
            int exitingTruck = bridge.poll();
            totalWeightOnBridge -= exitingTruck; // 다리를 빠져나간 트럭의 무게 제거

            // 대기 트럭이 남아있고, 다리에 올라갈 수 있는지 체크
            if (index < truck_weights.length) {
                if (totalWeightOnBridge + truck_weights[index] <= weight) {
                    // 새로운 트럭을 다리에 올림
                    bridge.add(truck_weights[index]);
                    totalWeightOnBridge += truck_weights[index];
                    index++;
                } else {
                    // 트럭이 다리 위에 올라갈 수 없으면 빈 공간 추가
                    bridge.add(0);
                }
            }
        }

        return time;
    }
}
