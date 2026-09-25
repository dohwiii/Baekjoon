import java.util.*;
// N 50 이하
// road 2,000 이하
// 500,000
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        final int INF = 500_001;
        int[] time = new int[N+1];
        PriorityQueue<Town> pq = new PriorityQueue<>();
        List<Town>[] list = new List[N+1];
        
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] r : road) {
            list[r[0]].add(new Town(r[1], r[2]));
            list[r[1]].add(new Town(r[0], r[2]));
        }
        pq.offer(new Town(1, 0));
        Arrays.fill(time, INF);
        time[1] = 0;
        
        while(!pq.isEmpty()) {
            Town now = pq.poll();
            
            for(Town next : list[now.town]) {
                if(time[next.town] > time[now.town] + next.time) {
                    time[next.town] = time[now.town] + next.time;
                    pq.offer(new Town(next.town, time[next.town]));
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(time[i] <= K) {
                answer++;
            }
        }
        

        return answer;
    }
    static class Town implements Comparable<Town> {
        int town;
        int time;
        
        public Town(int town, int time) {
            this.town=town;
            this.time=time;
        }
        
        @Override
        public int compareTo(Town t) {
            return this.time - t.time;
        }
    }
}