
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static List<Node>[] list;
    static int[] dist;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += solve(1, u);
        res1 += solve(u, v);
        res1 += solve(v, N);

        int res2 = 0;
        res2 += solve(1, v);
        res2 += solve(v, u);
        res2 += solve(u, N);

        if (res1 >= INF || res2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    public static int solve(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.node == end) {
                break;
            }
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
        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int node, value;

    public Node(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
