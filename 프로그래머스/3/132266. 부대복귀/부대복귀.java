import java.util.*;

class Solution {
    static List<Integer>[] list;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] r : roads) {
            // 양방향
            list[r[0]].add(r[1]);
            list[r[1]].add(r[0]);
        }
        int index = 0;
        int[] temp = bfs(destination, n);
        for(int a : sources) {
            answer[index] = temp[sources[index]];
            index++;
        }
        
        // sources -> destination
        // 복귀가 불가능한 경우 해당 부대원의 최단시간은 -1
        return answer;
    }
    private static int[] bfs(int node, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        queue.offer(new Node(node, 0));
        dist[node] = 0;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int next : list[now.node]) {
                if(dist[next] == -1) {
                    queue.offer(new Node(next, now.dist + 1));
                    dist[next] = now.dist + 1;
                }
            }
        }
        return dist;
    }
    static class Node {
        int node, dist;
        
        public Node(int node, int dist) {
            this.node=node;
            this.dist=dist;
        }
    }
}