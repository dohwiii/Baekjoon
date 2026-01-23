import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());    // 도시의 개수
        M = Integer.parseInt(br.readLine());    // 버스의 개수
        map = new int[N][N];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   // 출발
            int e = Integer.parseInt(st.nextToken());   // 도착
            int v = Integer.parseInt(st.nextToken());   // 비용
            list[s].add(new Node(e, v));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, 100_000_000_001L);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.value) {
                continue;
            }

            for (Node next : list[now.node]) {
                if (dist[next.node] > dist[now.node] + next.value) {
                    dist[next.node] = dist[now.node] + next.value;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        System.out.println(dist[end]);


    }

    static class Node implements Comparable<Node> {
        int node;
        long value;


        public Node(int node, long value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(o.value, this.value);
        }

    }

}