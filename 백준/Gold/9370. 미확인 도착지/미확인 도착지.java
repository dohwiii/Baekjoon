
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, S, G, H;
    static final long INF = 50000001L;
    static List<Node>[] list;
    static long[] dist;
    static PriorityQueue<Integer> ansList;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static List<Node>[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //교차로 개수
            M = Integer.parseInt(st.nextToken()); //도로 개수
            K = Integer.parseInt(st.nextToken()); //목적지 후보 개수

            dist = new long[N + 1]; //최단거리
            path = new ArrayList[N + 1];
            list = new ArrayList[N + 1]; //인접 그래프
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken()); //출발지
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, d));
                list[b].add(new Node(a, d));
            }
            ansList = new PriorityQueue<>();
            //목적지 후보
            for (int i = 0; i < K; i++) {
                int candidate = Integer.parseInt(br.readLine());
                long res1 = dijkstra(S, G) + dijkstra(G, H) + dijkstra(H, candidate);
                long res2 = dijkstra(S, H) + dijkstra(H, G) + dijkstra(G, candidate);
                long res3 = dijkstra(S, candidate);

                if (Math.min(res1, res2) == res3) {
                    ansList.offer(candidate);
                }
            }

            while (!ansList.isEmpty()) {
                sb.append(ansList.poll()).append(" ");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void isShortRoute(int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(end);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == S) {
                return;
            }
            for (Node node : path[now]) {
                if ((node.end == G && now == H) || (node.end == H && now == G)) {
                    ansList.offer(end);
                    return;
                }
                queue.add(node.end);
            }
        }
    }

    public static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.end == end) {
                break;
            }
            if (dist[now.end] < now.value) {
                continue;
            }
            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node next : list[now.end]) {
                if (!visited[next.end]) {
                    if (dist[next.end] > dist[now.end] + next.value) {
                        dist[next.end] = dist[now.end] + next.value;
                        path[next.end] = new ArrayList<>(); //경로 저장
                        path[next.end].add(new Node(now.end, dist[next.end]));
                        pq.offer(new Node(next.end, dist[next.end]));
                    } else if (dist[next.end] == dist[now.end] + next.value) {
                        path[next.end].add(new Node(now.end, dist[next.end]));
                    }
                }

            }
        }
        return dist[end];

    }
}

class Node implements Comparable<Node> {
    int end;
    long value;

    public Node(int end, long value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.value, o.value);
    }
}