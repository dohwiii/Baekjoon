
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, D;
    static List<Node>[] list;
    static boolean[] visited;
    static final long INF = Long.MAX_VALUE;
    static long result;
    static long[] dist;
    static List<Node>[] path;
    static boolean[][] shortVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            list = new ArrayList[N];
            dist = new long[N];
            visited = new boolean[N];
            path = new ArrayList[N];
            shortVisited = new boolean[N][N];
            result = -1;

            for (int i = 0; i < N; i++) {
                path[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, c)); //단방향
            }
            dijkstra(S); //최단 경로 알아냄
            remove(S, D); //최단경로 쳐냄
            dijkstra(S);
            if (dist[D] != INF) {
                result = dist[D];
            }
            bw.write(result + "");
            bw.write("\n");

        }
        bw.flush();
        bw.close();

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            //이미 도착한 시간보다 현재 시간이 더 크다면 탐색할 필요 없음
            if (dist[now.end] < now.value) {
                continue;
            }
            if (now.end == D) {
                continue;
            }
            for (Node next : list[now.end]) {
                if (shortVisited[now.end][next.end]) {
                    continue;
                }
                if (dist[next.end] > dist[now.end] + next.value) {
                    dist[next.end] = dist[now.end] + next.value;
                    path[next.end] = new ArrayList<>();
                    path[next.end].add(new Node(now.end, dist[now.end] + next.value));
                    pq.add(new Node(next.end, dist[next.end]));
                } else if (dist[next.end] == dist[now.end] + next.value) {
                    path[next.end].add(new Node(now.end, dist[now.end] + next.value));
                }
            }
        }

    }

    public static void remove(int s, int d) {
        if (s == d) {
            return;
        }
        for (Node n : path[d]) {
            if (!shortVisited[n.end][d]) {
                shortVisited[n.end][d] = true;
                remove(s, n.end);
            }
        }
    }

}

class Node implements Comparable<Node> {
    int end;
    long value;

    public Node(int end, long value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.value, o.value);
    }
}