import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static List<Node>[] graph;
    static final int INF = 800_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점 개수
        E = Integer.parseInt(st.nextToken());  // 간선 개수
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 양방향
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 다익스트라: 한 정점으로부터 출발해서 그 정점에서부터 모든 정점까지의 최단거리 (1->N)
        int[][] dist = new int[N + 1][N + 1];
        dijkstra(1, dist);
        dijkstra(u, dist);
        dijkstra(v, dist);

        // 1 -> u -> v -> N
        // 1 -> v -> u -> N

        int route1 = INF, route2 = INF;
        if (dist[1][u] != INF && dist[u][v] != INF && dist[v][N] != INF)
            route1 = dist[1][u] + dist[u][v] + dist[v][N];
        if (dist[1][v] != INF && dist[v][u] != INF && dist[u][N] != INF)
            route2 = dist[1][v] + dist[v][u] + dist[u][N];

        int result = Math.min(route1, route2);
        System.out.println(result == INF ? -1 : result);
    }

    private static void dijkstra(int node, int[][] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist[node], INF);
        dist[node][node] = 0;
        pq.offer(new Node(node, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[node][now.node] < now.dist) {
                continue;
            }

            for (Node next : graph[now.node]) {
                if (dist[node][next.node] > dist[node][now.node] + next.dist) {
                    dist[node][next.node] = dist[node][now.node] + next.dist;
                    pq.offer(new Node(next.node, dist[node][next.node]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node, dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}