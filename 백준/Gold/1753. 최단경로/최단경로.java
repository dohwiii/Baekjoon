
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        list = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());    //시작 정점

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        bfs(start);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static void bfs(int node) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(node, 0));
        dist[node] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.value > dist[now.node]) {
                continue;
            }

            for (Node next : list[now.node]) {
                if (dist[next.node] > dist[now.node] + next.value) {
                    dist[next.node] = dist[now.node] + next.value;
                    queue.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
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
        return this.value - o.value;
    }
    
}
