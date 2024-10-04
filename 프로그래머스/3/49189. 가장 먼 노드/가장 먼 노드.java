import java.util.*;
class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] depth;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        depth = new int[n+1];
        visited = new boolean[n+1];
        list = new List[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1));
        Arrays.fill(depth, Integer.MAX_VALUE);
        depth[1] = 0;
        int maxDepth = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            for(int next : list[now.v]) {
                int nextCost = Math.min(depth[next], depth[now.v] + 1);
                if(depth[next] > nextCost) {
                    depth[next] = nextCost;
                    pq.offer(new Node(next, nextCost));
                    maxDepth = Math.max(maxDepth, depth[next]);
                }
            }
        }
        for(int i=1; i<=n; i++) {
            if(depth[i] == maxDepth) {
                answer++;
            }
        }
        
        return answer;
    }

}
class Node implements Comparable<Node> {
    int v, c;
    public Node(int v, int c) {
        this.v=v;
        this.c=c;
    }
    @Override
    public int compareTo(Node n) {
        return this.c - n.c;
    }
}