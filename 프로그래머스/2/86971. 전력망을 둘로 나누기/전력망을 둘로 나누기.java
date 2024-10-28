import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] child;
    
    public int solution(int n, int[][] wires) {
        list = new List[n + 1];
        child = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        int max = Arrays.stream(child).max().getAsInt();
        int minDiff = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(child));
        
        for(int i=n; i>=2; i--) {
            int diff = max - child[i];
            minDiff = Math.min(minDiff, Math.abs(diff - child[i]));
        }

        return minDiff;
    }
    public int dfs(int now) {
        if(child[now] != 0) {
            return child[now];
        }
        child[now] = 1;
        visited[now] = true;
        
        for(int next : list[now]) {
            if(!visited[next]) {
                child[now] += dfs(next);
            }
        }
        return child[now];
    }
}