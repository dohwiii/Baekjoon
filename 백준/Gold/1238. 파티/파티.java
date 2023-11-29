
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static List<Party>[] list;
    static int[][] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[s].add(new Party(e, time));
//            dist[s][e] = time;
        }
        for (int i = 1; i <= N; i++) {
            depart(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i][X] + dist[X][i]);
        }

        System.out.println(max);

    }

    //집 -> X
    public static void depart(int start) {
        PriorityQueue<Party> pqueue = new PriorityQueue<>();
        pqueue.add(new Party(start, 0));
//        visited = new boolean[N + 1];
//        visited[start] = true;

        while (!pqueue.isEmpty()) {
            Party now = pqueue.poll();

            for (Party next : list[now.node]) {
                if (next.node == start) {
                    continue;
                }
                if (dist[start][next.node] > now.time + next.time) {
                    dist[start][next.node] = now.time + next.time;
                    pqueue.add(new Party(next.node, now.time + next.time));
                }
            }
        }

    }
}

class Party implements Comparable<Party> {
    int node, time;


    public Party(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Party o) {
        return this.time - o.time;
    }
}