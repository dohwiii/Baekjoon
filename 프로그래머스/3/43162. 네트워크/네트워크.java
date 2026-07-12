import java.util.*;

class Solution {
    static List<Integer>[] list;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new List[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) {
                    continue;
                }
                if(computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, visited);
                answer++;
            }
        }
        
        return answer;
    }
    private static void dfs(int now, boolean[] visited) {
        if(visited[now]) {
            return;
        }
        visited[now] = true;
        
        for(int next : list[now]) {
            if(!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}