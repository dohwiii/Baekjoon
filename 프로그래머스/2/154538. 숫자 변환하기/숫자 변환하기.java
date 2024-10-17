import java.util.*;
class Solution {
    static Queue<Integer> queue;
    static int[] visited;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        visited = new int[y + 1];
        
        return bfs(x, y, n);
    }
    public static int bfs(int node, int y, int n) {
        queue = new ArrayDeque<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int next = 0;
            if(now == y) {
                return visited[now];
            }
            addQueue(now + n, now, y);
            addQueue(now * 2, now, y);
            addQueue(now * 3, now, y);           
        }
        return -1;
    }
    public static void addQueue(int next, int now, int y) {
        if(next <= y && visited[next] == 0) {
            queue.offer(next);
            visited[next] = visited[now] + 1;
        }
    }
}