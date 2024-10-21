class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int nowD = 0;  // 현재 배달 중인 상자 수
        int nowP = 0;  // 현재 수거 중인 상자 수
        
        // 맨 끝집부터 시작하여 처리
        for (int i = n - 1; i >= 0; i--) {
            // 현재 집에서 처리해야 할 배달 상자와 수거 상자가 남아 있는 동안
            while (deliveries[i] > 0 || pickups[i] > 0) {
                answer += (i + 1) * 2;  // 현재 위치까지 왕복 거리 추가
                
                // 배달 가능한 만큼 처리
                nowD = 0;
                nowP = 0;
                
                // 트럭이 운반할 수 있는 최대 용량(cap)만큼 배달 및 수거 진행
                for (int j = i; j >= 0 && nowD < cap; j--) {
                    int deliverable = Math.min(cap - nowD, deliveries[j]);
                    deliveries[j] -= deliverable;
                    nowD += deliverable;
                }
                
                // 수거 가능한 만큼 처리
                for (int j = i; j >= 0 && nowP < cap; j--) {
                    int pickupable = Math.min(cap - nowP, pickups[j]);
                    pickups[j] -= pickupable;
                    nowP += pickupable;
                }
            }
        }
        
        return answer;
    }
}
