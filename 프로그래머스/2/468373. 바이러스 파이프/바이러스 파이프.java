import java.util.*;

// 파이프는 한번에 한 종류만 열고 닫을 수 있음
// 1-A, 2-B, 3-C 파이프 종류
// 파이프 종류별 여는 건 조합으로, 근데 일단 infection 노드와 연결된 파이프를 열어야함
// infection노드에 연결된 파이프종류를 우선적으로 조합처리? -> 근데 그러면 다음 노드에서는 무슨 파이프 열지 기준을 어떻게 정해야 함?
// 그냥 A, B, C를 기준으로 순열 구하기?

// 내가 놓친 부분
// 1. visitedEdge 만들어놓고 방문처리 안함
// 2. 같은 타입의 재선택이 가능하다. (중복 순열 가능 (A → B → A))
class Solution {
    static List<Node>[] list;
    static int[] types;
    static int max;
    static int count;
    static boolean[] infected;
    static Set<Integer> typeSet;
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        typeSet = new HashSet<>();
        infected = new boolean[n+1];
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
        count = 1;
        infected[infection] = true;
        permutation(0, new int[k], k, infection, n);
        // 최대 k번 파이프 열고 닫은 후, 감영된 배양체 개수의 최댓값
        return max;
    }
    private static void bfs(int n, int selected) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        
        for(int i=1; i<=n; i++) {
            if(infected[i]) {
                visited[i] = true;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(Node next : list[now]) {
                if(!visited[next.node]) {
                    if(next.type == selected) {
                        visited[next.node] = true;
                        infected[next.node] = true;
                        queue.offer(next.node);
                        count++;
                    }
                }

            }

        }


    }
    private static void permutation(int depth, int[] selected, int k, int infection, int n) {
        if(depth == k) {
            max = Math.max(max, count);
            return;
        }
           
        for(int i=0; i<types.length; i++) {
            boolean[] backup = infected.clone();
            int backupCount = count;
            
            bfs(n, types[i]);
            permutation(depth+1, selected, k, infection, n);
            
            infected = backup;
            count = backupCount;
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