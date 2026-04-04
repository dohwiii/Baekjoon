import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static List<Node>[] graph;
    static final int INF = 200_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());    //시작 정점
        graph = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 방향 그래프 u -> v
            graph[u].add(new Node(v, w));
        }
        int[] dist = dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
                continue;
            }
            sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }

    private static int[] dijkstra(int node) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[node] = 0;
        pq.offer(new Node(node, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.weight) {
                continue;
            }

            for (Node next : graph[now.node]) {
                if (dist[next.node] > dist[now.node] + next.weight) {
                    dist[next.node] = dist[now.node] + next.weight;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}