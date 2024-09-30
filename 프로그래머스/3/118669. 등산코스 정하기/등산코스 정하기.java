import java.util.*;

class Solution {
    static List<Node>[] list;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        list = new List[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        
        for (int gate : gates) gateSet.add(gate);
        for (int summit : summits) summitSet.add(summit);
        
        for(int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int v = path[2];
            list[a].add(new Node(b, v));
            list[b].add(new Node(a, v));
        }
        
        int[] minIntensity = new int[n+1];
        Arrays.fill(minIntensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int gate : gates) {
            pq.offer(new Node(gate, 0));
            minIntensity[gate] = 0;
        }
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            // 만약 산봉우리에 도달하면 그 이상 탐색하지 않는다.
            if (summitSet.contains(now.vertex)) continue;
            
            if(minIntensity[now.vertex] < now.cost) {
                continue;
            }
            
            for(Node next : list[now.vertex]) {
                int newIntensity = Math.max(minIntensity[now.vertex], next.cost);
                if(newIntensity < minIntensity[next.vertex] && !gateSet.contains(next.vertex)) {
                    pq.offer(new Node(next.vertex, newIntensity));
                    minIntensity[next.vertex] = newIntensity;
                }
            }
        }
        // 최소 intensity 산봉우리 찾기
        int minSummit = -1;
        int minSummitIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits); // 산봉우리 번호가 작은 순서대로 찾기 위해 정렬

        for (int summit : summits) {
            if (minIntensity[summit] < minSummitIntensity) {
                minSummitIntensity = minIntensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minSummitIntensity};
    }

}
class Node implements Comparable<Node> {
    int vertex, cost;
    
    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost; // 최소 비용을 기준으로 우선순위 큐에서 정렬
    }
}
