import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 5_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());


        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] edges = new int[M * 2 + W][3];
            // 도로
            for (int i = 0; i < M * 2; i += 2) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[i] = new int[]{S, E, T};
                edges[i + 1] = new int[]{E, S, T};
            }
            // 웜홀
            for (int i = M * 2; i < M * 2 + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[i] = new int[]{S, E, T * -1};
            }
            int[] dist = new int[N + 1];    // 모든 노드가 0으로 다 시작점이 됨
            boolean hasNegCycle = false;
            // N-1번 반복
            bellmanFord(edges, dist,  N);
            // 마지막 한번
            for (int[] v : edges) {
                int s = v[0];
                int e = v[1];
                int p = v[2];
                if (dist[s] != INF && dist[e] > dist[s] + p) {
                    dist[e] = dist[s] + p;
                    hasNegCycle = true;
                    break;
                }
            }
            if (hasNegCycle) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }
        System.out.println(sb);

    }

    private static void bellmanFord(int[][] edges, int[] dist, int N) {
        // N-1번 반복
        for (int i = 0; i < N - 1; i++) {
            for (int[] v : edges) {
                int s = v[0];
                int e = v[1];
                int p = v[2];
                if (dist[s] != INF && dist[e] > dist[s] + p) {
                    dist[e] = dist[s] + p;
                }
            }
        }

    }

}