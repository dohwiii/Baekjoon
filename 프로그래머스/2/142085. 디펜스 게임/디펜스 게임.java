import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int totalSoldierUsed = 0;   //사용한 병사 수
        int round = 0;
        
        if(k >= enemy.length) { //무적권 횟수가 라운드보다 크거나 같다면 -> 라운드 끝까지 갈 수 있음
            return enemy.length;
        }
        for(int e : enemy) {
            totalSoldierUsed += e;  //병사 사용
            pq.offer(e);
            
            if(totalSoldierUsed > n) {
                if(k > 0) {
                    totalSoldierUsed -= pq.poll();
                    k--;
                }
                else {
                    break;  //무족권도 없음
                }
            }
            round++;
        }
        
        return round;
    }
}