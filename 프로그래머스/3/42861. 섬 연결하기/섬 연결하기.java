import java.util.*;

// 크루스칼 - 모든 노드를 연결하는데 드는 최소비용
// union-find로 그룹을 묶고 (사이클 생성 방지), 경로생성하면서 조상이 같은지 체크해서 같지 않을경우 경로 잇기 
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        PriorityQueue<Island> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<costs.length; i++) {
            pq.offer(new Island(costs[i][0], costs[i][1], costs[i][2]));
            // union(costs[i][0], costs[i][1]); // 연결
        }
        int cnt = 0;    // 노드 - 1개만 연결
        
        while(!pq.isEmpty()) {
            Island now = pq.poll();
            int i1 = now.i1;
            int i2 = now.i2;
            int c = now.cost;
            
            if(union(i1, i2)) {
                answer += c; // 비용
                cnt++;  // 경로 생성
            }
            
            if(cnt == n - 1) {
                break;
            }
        }
    
        
        
        return answer;
    }
    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    private boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
            return true;
        }
        return false;
    }
    static class Island implements Comparable<Island> {
        int i1, i2;
        int cost;
        
        public Island(int i1, int i2, int cost) {
            this.i1=i1;
            this.i2=i2;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Island i) {  // 비용 오름차순 정렬
            return this.cost - i.cost;
        }
    }
}