import java.util.*;

class Solution {
    static List<Node>[] list;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        list = new List[N+1];
        for(int i=0;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] r : road) {
            int u = r[0], e = r[1],  v = r[2];
            list[u].add(new Node(e, v));
            list[e].add(new Node(u, v));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(dist[now.vertex] < now.cost) {
                continue;
            }
            
            for(Node next : list[now.vertex]) {
                int nextDist = dist[now.vertex] + next.cost;
                
                if(nextDist <= K) { //배달 가능
                    if(dist[next.vertex] > nextDist) {
                        dist[next.vertex] = nextDist;
                        pq.offer(new Node(next.vertex, nextDist));
                    }
                }
            }
        }
        for(int i=2; i<=N; i++) {
            if(dist[i] != Integer.MAX_VALUE) {
                answer++;
            }
        }
        System.out.print(Arrays.toString(dist));
        return answer;
    }
}
class Node implements Comparable<Node> {
    int vertex, cost;
    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}