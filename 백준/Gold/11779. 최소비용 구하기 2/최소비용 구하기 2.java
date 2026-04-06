import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<City>[] graph;
    static final int INF = 100_000_001;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        prev = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new City(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(start);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");
        Stack<Integer> route = new Stack<>();
        int now = end;
        route.add(end);
        while (true) {
            int next = prev[now];
            if (next == 0) {
                break;
            }
            route.add(next);
            now = next;
        }
        sb.append(route.size() + "\n");
        while (!route.isEmpty()) {
            sb.append(route.pop() + " ");
        }
        System.out.println(sb);
    }

    private static int[] dijkstra(int node) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[node] = 0;
        pq.offer(new City(node, 0));
        Arrays.fill(prev, -1);
        prev[node] = 0;

        while (!pq.isEmpty()) {
            City now = pq.poll();
            if (dist[now.city] < now.cost) {
                continue;
            }

            for (City next : graph[now.city]) {
                if (dist[next.city] > dist[now.city] + next.cost) {
                    dist[next.city] = dist[now.city] + next.cost;
                    pq.offer(new City(next.city, dist[next.city]));
                    prev[next.city] = now.city; // 직전 노드 번호 기록
                }
            }
        }
        return dist;

    }

    static class City implements Comparable<City> {
        int city, cost;

        public City(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }

    }

}