import java.util.*;
// N개의 마을 중 K시간 이하로 배달 가능한 곳 카운트하기
// 1번 마을 출발
// 다익스트라
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Delivery>[] list = new List[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int d = road[i][2];
            list[x].add(new Delivery(y, d));
            list[y].add(new Delivery(x, d));
        }
        PriorityQueue<Delivery> pq = new PriorityQueue<>();
        pq.offer(new Delivery(1, 0));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Delivery now = pq.poll();
            
            for(Delivery next : list[now.town]) {
                if(dist[next.town] > dist[now.town] + next.dist) {
                    dist[next.town] = dist[now.town] + next.dist;
                    pq.offer(new Delivery(next.town, dist[next.town]));
                }
            }
        }
        // dist 배열 K 이하 검사
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    static class Delivery implements Comparable<Delivery> {
        int town;
        int dist;
        
        public Delivery(int town, int dist) {
            this.town=town;
            this.dist=dist;
        }
        @Override
        public int compareTo(Delivery d) {
            return this.dist - d.dist;
        }
    }
}