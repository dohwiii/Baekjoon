import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        final int INF = 199_991;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점
        int E = Integer.parseInt(st.nextToken());   // 간선
        int K = Integer.parseInt(br.readLine());    // 시작 정점
        list = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        dist[K] = 0;

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
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            }
            else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}
class Node implements Comparable<Node>{
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
//        return this.value - o.value;    // 오름차순
        return Integer.compare(this.value, o.value);
    }
}