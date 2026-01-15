import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            this.in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32); // 공백/개행 스킵

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static class Node implements Comparable<Node> {
        int node, value;
        Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static List<Node>[] list;

    public static void main(String[] args) throws Exception {
        final int INF = 199_991; // 이 문제 조건이면 충분히 큼(여유 더 주고 싶으면 1e9도 OK)

        FastScanner fs = new FastScanner(System.in);
        int V = fs.nextInt();
        int E = fs.nextInt();
        int K = fs.nextInt();

        list = new List[V + 1];
        for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            list[u].add(new Node(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[K] = 0;
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.node] < now.value) continue; // 최신성 체크

            for (Node next : list[now.node]) {
                int nd = dist[now.node] + next.value;
                if (dist[next.node] > nd) {
                    dist[next.node] = nd;
                    pq.offer(new Node(next.node, nd));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }
        System.out.print(sb);
    }
}
