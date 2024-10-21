public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;  // answer를 0으로 초기화
        int deliver = 0, pickup = 0;

        // 끝에서부터 집을 탐색
        for (int i = n - 1; i >= 0; i--) {
            // 현재 집까지의 배달과 수거를 누적
            deliver += deliveries[i];
            pickup += pickups[i];

            // 배달할 상자나 수거할 상자가 남아 있을 경우 처리
            while (deliver > 0 || pickup > 0) {
                // 현재 집까지 왕복 거리 계산
                answer += (i + 1) * 2;

                // 트럭의 용량만큼 배달과 수거를 처리
                deliver -= cap;
                pickup -= cap;
            }
        }

        return answer;
    }
}
