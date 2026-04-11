
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Edge>[] graph;
    static final int INF = 5_000_001;
    static List<Integer>[] visitedEdge;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            visitedEdge = new List[N];
            visited = new boolean[N][N];
            graph = new List[N];    // 0번 ~ N-1번
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                visitedEdge[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   // 시작
            int D = Integer.parseInt(st.nextToken());   // 도착

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());   // 자연수 1 ~ 1000
                graph[u].add(new Edge(v, p));
            }

            // 최단경로 구하기
            int[] dist = dijkstra(S);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(D);
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int prev : visitedEdge[now]) {
                    if (!visited[prev][now]) {
                        visited[prev][now] = true;
                        queue.offer(prev);
                    }
                }
            }
            dist = dijkstra(S);
            if (dist[D] == INF) {
                sb.append("-1");
            } else {
                sb.append(dist[D]);
            }
            sb.append("\n");


        }
        System.out.println(sb);


    }

    private static int[] dijkstra(int node) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[node] = 0;
        pq.offer(new Edge(node, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge next : graph[now.node]) {
                if (!visited[now.node][next.node]) {
                    if (dist[now.node] != INF && dist[next.node] > dist[now.node] + next.dist) {
                        dist[next.node] = dist[now.node] + next.dist;
                        pq.offer(new Edge(next.node, dist[next.node]));
                        visitedEdge[next.node].clear();
                        visitedEdge[next.node].add(now.node);
                    } else if (dist[now.node] != INF && dist[next.node] == dist[now.node] + next.dist) {
                        visitedEdge[next.node].add(now.node);
                    }
                }

            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int node, dist;

        public Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
}