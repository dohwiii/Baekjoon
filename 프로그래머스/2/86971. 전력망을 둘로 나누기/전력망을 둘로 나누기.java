import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] w : wires) {
            // 양방향
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }
   
        int minDiff = 100;
        boolean[][] visited = new boolean[n+1][n+1];
        for(int[] wire : wires) {            
            int w1 = wire[0];
            int w2 = wire[1];
            visited[w1][w2] = true;
            visited[w2][w1] = true;

            cnt = 0;
            dfs(1, visited);
            minDiff = Math.min(minDiff, Math.abs(cnt - (n - cnt)));

            visited[w1][w2] = false;
            visited[w2][w1] = false;
            
        }
        
        
        // 송전탑 개수의 차이(절대값)
        return minDiff;
    }
    private static void dfs(int node, boolean[][] visited) {
        cnt++;
        
        for(int next : list[node]) {
            if(!visited[node][next] && !visited[next][node]) {
                visited[node][next] = true;
                visited[next][node] = true;
                dfs(next, visited);
                visited[node][next] = false;
                visited[next][node] = false;
            }
        }
    }
}