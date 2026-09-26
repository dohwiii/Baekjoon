import java.util.*;

// 파이프는 한번에 한 종류만 열고 닫을 수 있음
// 1-A, 2-B, 3-C 파이프 종류
// 파이프 종류별 여는 건 조합으로, 근데 일단 infection 노드와 연결된 파이프를 열어야함
// infection노드에 연결된 파이프종류를 우선적으로 조합처리? -> 근데 그러면 다음 노드에서는 무슨 파이프 열지 기준을 어떻게 정해야 함?
// 그냥 A, B, C를 기준으로 순열 구하기?

class Solution {
    static List<Node>[] list;
    static int[] types;
    static int max;
    static Set<Integer> visitedNode;
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        
        Set<Integer> typeSet = new HashSet<>();   // 타입종류
        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            // 양방향
            list[e[0]].add(new Node(e[1], e[2]));
            list[e[1]].add(new Node(e[0], e[2]));
            typeSet.add(e[2]);
        }
        int idx = 0;
        types = new int[typeSet.size()];
        for(int a: typeSet) {
            types[idx++] = a;
        }
        permutation(0, new int[k], new boolean[typeSet.size()], k, infection, n);
        // 최대 k번 파이프 열고 닫은 후, 감영된 배양체 개수의 최댓값
        return max;
    }
    private static void bfs(int start, int n, int selected, int k, boolean[][] visitedEdge) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        visitedNode.add(start);
        
        for(int a : visitedNode) {
            queue.offer(a);
        }
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(Node next : list[now]) {
                if(!visitedEdge[now][next.node] && !visitedEdge[next.node][now]) {
                    if(next.type == selected) {
                        visitedEdge[next.node][now] = true;
                        visitedEdge[now][next.node] = true;
                        visitedNode.add(next.node);
                        queue.offer(next.node);
                    }
                }

            }

        }


    }
    private static void permutation(int depth, int[] selected, boolean[] visited, int k, int infection, int n) {
        if(depth == k) { // 다 뽑음
            boolean[][] visitedEdge = new boolean[n+1][n+1];
            visitedNode = new HashSet<>();
            for(int i=0; i<selected.length; i++) {
                bfs(infection, n, selected[i], k, visitedEdge);
            }
            max = Math.max(max, visitedNode.size());
            return;
        }
        
        for(int i=0; i<types.length; i++) {
            selected[depth] = types[i];
            permutation(depth+1, selected, visited, k, infection, n);
        }
    }
    static class Node {
        int node, type;
        
        public Node(int node, int type) {
            this.node=node;
            this.type=type;
        }
    }
    
}