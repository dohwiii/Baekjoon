
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Node>[] list;
    static boolean[][] visited;
    static long INF = Long.MAX_VALUE;
    static long result = Long.MAX_VALUE;
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        dijkstra();
        for (int i = 0; i <= K; i++) {
            result = Math.min(result, dist[N][i]);
        }
        System.out.println(result);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new long[N + 1][K + 1];
        visited = new boolean[N + 1][K + 1];
        for (int i = 2; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.end == N && now.bridge <= K) {
                result = Math.min(result, dist[now.end][now.bridge]);
            }

            if (visited[now.end][now.bridge]) {
                continue;
            }

            visited[now.end][now.bridge] = true;

            for (Node next : list[now.end]) {
                // 다리를 하나도 사용하지 않는 경우
                if (dist[next.end][now.bridge] > dist[now.end][now.bridge] + next.value) {
                    dist[next.end][now.bridge] = dist[now.end][now.bridge] + next.value;
                    pq.add(new Node(next.end, now.bridge, dist[next.end][now.bridge]));
                }
                // 다리를 사용하는 경우
                if (now.bridge < K && dist[next.end][now.bridge + 1] > dist[now.end][now.bridge]) {
                    dist[next.end][now.bridge + 1] = dist[now.end][now.bridge];
                    pq.add(new Node(next.end, now.bridge + 1, dist[next.end][now.bridge + 1]));
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
    int end, bridge;
    long value;

    public Node(int end, long value) {
        this.end = end;
        this.value = value;
    }

    public Node(int end, int bridge, long value) {
        this.end = end;
        this.bridge = bridge;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.value, o.value);
    }
}