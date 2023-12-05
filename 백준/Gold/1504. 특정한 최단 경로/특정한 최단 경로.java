
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static List<Pos>[] list;
    static int u, v;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Pos(b, c));
            list[b].add(new Pos(a, c));
        }
        //반드시 통과해야하는 정점
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, u);
        res1 += dijkstra(u, v);
        res1 += dijkstra(v, N);

        int res2 = 0;
        res2 += dijkstra(1, v);
        res2 += dijkstra(v, u);
        res2 += dijkstra(u, N);

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(res1, res2));
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        pq.add(new Pos(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pos now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Pos next : list[now.end]) {
                    if (dist[next.end] > dist[now.end] + next.value) {
                        dist[next.end] = dist[now.end] + next.value;
                        pq.add(new Pos(next.end, dist[next.end]));
                    }
                }
            }

        }
        return dist[end];
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