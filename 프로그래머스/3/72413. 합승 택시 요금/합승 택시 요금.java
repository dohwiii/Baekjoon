import java.util.*;

class Solution {
    static List<Node>[] list;
    static int ans;
    static int[][] money;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        money = new int[3][n+1];
        list = new List[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            int u = fare[0], v = fare[1], c = fare[2];
            list[u].add(new Node(v, c));
            list[v].add(new Node(u, c));
        }
        dijkstra(s, 0);
        dijkstra(a, 1);
        dijkstra(b, 2);
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            min = Math.min(min, money[0][i] + money[1][i] + money[2][i]);
        }
        return min;
        
    }
    public static void dijkstra(int start, int index) {
        Arrays.fill(money[index], Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        money[index][start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.c > money[index][now.v]) {
                continue;
            }
            
            for(Node next : list[now.v]) {
                int nextMoney = Math.min(money[index][next.v], money[index][now.v] + next.c);
                if(money[index][next.v] > nextMoney) {
                    money[index][next.v] = nextMoney;
                    pq.offer(new Node(next.v, nextMoney));
                }
            }
        }
    }
      
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