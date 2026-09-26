import java.util.*;

class Solution {
    static List<Integer>[] list;
    public int solution(int n, int[][] edge) {
        int answer = 1;
        list = new List[n+1];
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] e : edge) {
            // 양방향
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        int max = 0;
        int[] dist = bfs(1, n);
        for(int i=1; i<=n; i++) {
            if(dist[i] > max) {
                answer = 1;
                max = dist[i];
            }
            else if(max == dist[i]) {
                answer++;
            }
        }        
        // 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개
        return answer;
    }
    private static int[] bfs(int node, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int[] dist = new int[n+1];
        queue.offer(new Node(1, 0));
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int next : list[now.node]) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = now.step + 1;
                    queue.offer(new Node(next, now.step + 1));
                }
            }
        }
        return dist;
        
    }
    static class Node {
        int node, step;
        
        public Node(int node, int step) {
            this.node=node;
            this.step=step;
        }
    }
} 