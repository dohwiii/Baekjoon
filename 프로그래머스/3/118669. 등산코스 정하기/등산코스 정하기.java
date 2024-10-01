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
        
        //출입구와 산봉우리 Set에 추가
        for(int gate : gates) {
            gateSet.add(gate);
        }
        for(int summit : summits) {
            summitSet.add(summit);
        }
        
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
            minIntensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(minIntensity[now.vertex] < now.cost) {   //현재 비용이 더 크다면 알아볼 필요가 없음
                continue;
            }
            if(summitSet.contains(now.vertex)) {
                continue;
            }
            
            for(Node next : list[now.vertex]) {
                int nextIntensity = Math.max(minIntensity[now.vertex], next.cost);
                
                if(gateSet.contains(next.vertex)) {
                    continue;
                }
                
                if(minIntensity[next.vertex] > nextIntensity) {
                    minIntensity[next.vertex] = nextIntensity;
                    pq.offer(new Node(next.vertex, nextIntensity));
                }
            }
        }
        // System.out.print(Arrays.toString(minIntensity));
        int minInten = Integer.MAX_VALUE;
        int mountain = 0;
        Arrays.sort(summits);
        
        for(int summit : summits) {
            if(minInten > minIntensity[summit]) {
                minInten = minIntensity[summit];
                mountain = summit;
            }
        }
        return new int[]{mountain, minInten};
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
