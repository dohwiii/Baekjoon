import java.util.*;

// 크루스칼 - 모든 노드를 연결하는데 드는 최소비용
// union-find로 그룹을 묶고 (사이클 생성 방지), 경로생성하면서 조상이 같은지 체크해서 같지 않을경우 경로 잇기 
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        int cnt = 0;    // 노드 - 1개만 연결
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        for(int i=0; i<costs.length; i++) {
            if(union(costs[i][0], costs[i][1])) {
                cnt++;
                answer += costs[i][2];
            }
            if(cnt == n-1) {
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

}