import java.util.*;

class Solution {
    static List<Node>[] list;
    static boolean[] visited;
    static int ans;
    static int[][] money;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        money = new int[3][n+1];
        visited = new boolean[n+1];
        Set<Integer> set = new HashSet<>();
        list = new List[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] fare : fares) {
            int u = fare[0], v = fare[1], c = fare[2];
            list[u].add(new Node(v, c));
            list[v].add(new Node(u, c));
        }
        solve(s, 0);
        solve(a, 1);
        solve(b, 2);
        
        for(int i=0; i<3; i++) {
            System.out.print(Arrays.toString(money[i]));
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            min = Math.min(min, money[0][i] + money[1][i] + money[2][i]);
        }
        return min;
    }
    public static void solve(int start, int index) {
        Arrays.fill(money[index], Integer.MAX_VALUE);
        money[index][start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(money[index][now.v] < now.c) continue;

            for(Node next : list[now.v]) {
                int newCost = Math.min(money[index][next.v], money[index][now.v] + next.c);
                if(money[index][next.v] > newCost) {
                    money[index][next.v] = newCost;
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
    }
   
//     public static int dfs(Node now) {
//         if(visited[now.v]) {
//             return money[now.v];
//         }
//         money[now.v] = now.c;
//         visited[now.v] = true;
        
//         for(Node next : list[now.v]) {
//             if(visited[next.v]) continue;
            
//             money[next.v] = Math.min(money[next.v], dfs(next) + now.c);
            
//         }
//         visited[now.v] = false;
//         return money[now.v];
//     }
}
class Node implements Comparable<Node>{
    int v, c;
    public Node(int v, int c) {
        this.v = v;
        this.c = c;
    }
    @Override
    public int compareTo(Node n) {
        return this.c - n.c;
    }
}