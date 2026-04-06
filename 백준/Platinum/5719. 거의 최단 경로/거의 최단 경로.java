import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static List<Node>[] graph;
    static List<Integer>[] parent;
    static final int INF = 500_001;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new List[N];
            parent = new List[N];
            visited = new boolean[N][N];    // 간선 기준으로 방문체크
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                // 단방향
                graph[s].add(new Node(e, t));
            }
            /**
             * 1. S -> E 최단 경로 구하기
             */
            int[] dist = dijkstra(S);
            int minDist = dist[E];  // E까지의 최단 경로

            /**
             *  2. 최단경로 거치는 노드들 visited true처리
             */
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(E);
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int prev : parent[now]) {
                    if (prev != -1 && !visited[prev][now]) {
                        visited[prev][now] = true;
                        queue.offer(prev);
                    }
                }
            }

            /**
             * 3. 방문 안한 경로 중 가장 짧은 경로 구하기
             */
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(S, 0));
            int[] dist2 = new int[N];
            Arrays.fill(dist2, INF);
            dist2[S] = 0;

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (dist2[now.node] < now.dist) {
                    continue;
                }

                for (Node next : graph[now.node]) {
                    if (!visited[now.node][next.node]) {  // 최단경로에 포함된 노드가 아니라면
                        if (dist2[next.node] > dist2[now.node] + next.dist) {
                            dist2[next.node] = dist2[now.node] + next.dist;
                            pq.offer(new Node(next.node, dist2[next.node]));
                        }
                    }
                }
            }
            if (dist2[E] == INF) {
                sb.append("-1");
            } else {
                sb.append(dist2[E]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        parent[start].add(-1);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.dist) {
                continue;
            }

            for (Node next : graph[now.node]) {
                if (dist[next.node] > dist[now.node] + next.dist) {
                    dist[next.node] = dist[now.node] + next.dist;
                    pq.offer(new Node(next.node, dist[next.node]));
                    parent[next.node].clear();  // 새로운 최단경로를 찾았으므로 리셋하고 추가
                    parent[next.node].add(now.node);   // 부모 노드
                }
                else if (dist[next.node] == dist[now.node] + next.dist) {
                    parent[next.node].add(now.node);   // 부모 노드
                }
            }
        }
        return dist;
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