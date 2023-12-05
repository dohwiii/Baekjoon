
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Pos>[] list;
    static final int INF = 50000000;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Pos(b, c));
            list[b].add(new Pos(a, c));
        }
        System.out.println(dijkstra(1));
        
    }

    public static int dijkstra(int start) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        int[] path = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, INF);
        pq.add(new Pos(start, 0));
        dist[start] = 0;
        int min = 0;

        while (!pq.isEmpty()) {
            Pos now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Pos next : list[now.end]) {
                    if (dist[next.end] > dist[now.end] + next.value) {
                        dist[next.end] = dist[now.end] + next.value;
                        path[next.end] = now.end; //경로
                        pq.add(new Pos(next.end, dist[next.end]));
                    }
                }
            }
        }
        min = dist[N];
        int to = N;
        int max = 0;

        while (to != 1) {
            int from = path[to];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = 0;
            pq.add(new Pos(1, 0));

            while (!pq.isEmpty()) {
                Pos now = pq.poll();

                for (Pos next : list[now.end]) {
                    if (from != now.end || to != next.end) {
                        if (dist[next.end] > dist[now.end] + next.value) {
                            dist[next.end] = dist[now.end] + next.value;
                            pq.add(new Pos(next.end, dist[next.end]));
                        }
                    }
                }
            }
            if (dist[N] > max) {
                max = dist[N];
            }
            to = from;
        }
        if (max == Integer.MAX_VALUE) {
            return -1;
        } else {
            return max - min;
        }

    }

}

class Pos implements Comparable<Pos> {
    int end, value;

    public Pos(int node, int value) {
        this.end = node;
        this.value = value;
    }

    @Override
    public int compareTo(Pos o) {
        return this.value - o.value;
    }
}