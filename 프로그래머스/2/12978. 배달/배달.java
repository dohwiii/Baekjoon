import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] list = new List[N + 1];
        for(int i=0; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int [] r : road) {
            int a = r[0];
            int b = r[1];
            int t = r[2];
            list[a].add(new Node(b, t));
            list[b].add(new Node(a, t));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.node] < now.time) {
                continue;
            }
            
            for(Node next : list[now.node]) {
                if(dist[next.node] > dist[now.node] + next.time) {
                    dist[next.node] = dist[now.node] + next.time;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    static class Node implements Comparable<Node> {
        int node, time;
        public Node(int node, int time) {
            this.node=node;
            this.time=time;
        }
        @Override
        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
    
    
}