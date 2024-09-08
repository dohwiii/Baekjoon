
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static PriorityQueue<Integer>[] pq;
    static boolean[] visited;
    static int[] order;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        order = new int[N + 1];
        pq = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            pq[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq[u].add(v);
            pq[v].add(u);
        }

        StringBuilder sb = new StringBuilder();
        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = idx++;

        while (!pq[node].isEmpty()) {
            int next = pq[node].poll();

            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}