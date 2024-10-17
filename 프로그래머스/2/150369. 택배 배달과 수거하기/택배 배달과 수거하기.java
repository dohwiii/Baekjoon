public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;  // 남은 배달할 상자의 개수
        int pickup = 0;    // 남은 수거할 상자의 개수

        for (int i = n - 1; i >= 0; i--) {
            // 현재 집에서 배달할 상자나 수거할 상자가 있는 경우
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int trips = 0;
                
                // 해당 집에서 배달할 상자와 수거할 상자 수 중 큰 값이 트럭이 한 번 이동할 때 최대 처리할 수 있는 수를 넘는지 확인
                while (delivery < deliveries[i] || pickup < pickups[i]) {
                    trips++;
                    delivery += cap;
                    pickup += cap;
                }

                // 해당 집까지 왕복한 거리를 계산
                answer += (i + 1) * 2 * trips;
                
                // 배달하고 수거한 수만큼 남은 배달 및 수거량 감소
                delivery -= deliveries[i];
                pickup -= pickups[i];
            }
        }

        return answer;
    }
}
