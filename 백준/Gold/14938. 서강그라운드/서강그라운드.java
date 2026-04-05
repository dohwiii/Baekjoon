
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] items;
    static List<Node>[] graph;
    static int[][] dist;
    static final int INF = 1501;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 지역 개수
        M = Integer.parseInt(st.nextToken());       // 수색 범위
        int R = Integer.parseInt(st.nextToken());   // 길의 개수
        graph = new List[N + 1];
        dist = new int[N + 1][N + 1];
        items = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            // 양방향
            graph[a].add(new Node(b, l));
            graph[b].add(new Node(a, l));
        }

        for (int start = 1; start <= N; start++) {
            findShortCut(start);
        }

        int maxItems = 0;

        for (int start = 1; start <= N; start++) {
            int sum = items[start];

            for (int dest = 1; dest <= N; dest++) {
                if (start == dest) {
                    continue;
                }
                if (dist[start][dest] <= M) {   // 수색 범위가 M 이하라면
                    sum += items[dest];
                }
            }
            maxItems = Math.max(maxItems, sum);
        }

        System.out.println(maxItems);


    }

    private static void findShortCut(int node) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(node, 0));
        dist[node][node] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[node][now.node] < now.dist) {
                continue;
            }

            for (Node next : graph[now.node]) {
                if (dist[node][next.node] > dist[node][now.node] + next.dist) {
                    dist[node][next.node] = dist[node][now.node] + next.dist;
                    pq.offer(new Node(next.node, dist[node][next.node]));
                }

            }
        }
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