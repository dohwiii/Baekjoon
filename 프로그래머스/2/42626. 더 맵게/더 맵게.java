import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 초기 조건으로 모든 음식의 스코빌 지수가 이미 K 이상인 경우 바로 0 반환
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov : scoville) {
            pq.offer(scov);
        }
        if (pq.peek() >= K) return 0;

        int answer = 0;

        // 조기 종료 조건을 루프 내에서 설정하여 계산
        while (pq.size() > 1) {
            int leastSpicy = pq.poll();
            if (leastSpicy >= K) return answer; // 조기 종료: 모두 K 이상

            int secondLeastSpicy = pq.poll();
            int newScoville = leastSpicy + 2 * secondLeastSpicy;
            pq.offer(newScoville);
            answer++;
        }

        // 최종 체크: 모든 음식을 섞었을 때도 K 미달인 경우
        return pq.peek() >= K ? answer : -1;
    }
}
