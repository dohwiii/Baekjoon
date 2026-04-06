import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static final int INF = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());   // 파티
        List<Town>[] graph = new List[N + 1];
        List<Town>[] revGraph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            // 단방향
            graph[s].add(new Town(e, t));
            revGraph[e].add(new Town(s, t));
        }
        // 1 -> X -> 1
        int[] go = dijkstra(X, revGraph);
        int[] back = dijkstra(X, graph);
        int maxSum = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            if (i == X) {
                continue;
            }
            sum += go[i] + back[i];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);


    }

    private static int[] dijkstra(int start, List<Town>[] graph) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Town(start, 0));

        while (!pq.isEmpty()) {
            Town now = pq.poll();

            for (Town next : graph[now.town]) {
                if (dist[next.town] > dist[now.town] + next.time) {
                    dist[next.town] = dist[now.town] + next.time;
                    pq.offer(new Town(next.town, dist[next.town]));
                }
            }
        }
        return dist;

    }

    static class Town implements Comparable<Town> {
        int town, time;

        public Town(int town, int time) {
            this.town = town;
            this.time = time;
        }

        @Override
        public int compareTo(Town o) {
            return this.time - o.time;
        }
    }

}