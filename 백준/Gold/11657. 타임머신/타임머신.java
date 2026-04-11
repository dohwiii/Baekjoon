
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];
        long[] dist = new long[N + 1];
        long INF = 5_000_001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{A, B, C};
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int s = edge[0];
                int e = edge[1];
                int d = edge[2];
                if (dist[s] != INF && dist[e] > dist[s] + d) {
                    dist[e] = dist[s] + d;
                }
            }
        }
        boolean hasNegCycle = false;
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int d = edge[2];
            if (dist[s] != INF && dist[e] > dist[s] + d) {
                dist[e] = dist[s] + d;
                hasNegCycle = true;
                break;
            }
        }
        if (hasNegCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                long value = dist[i] == INF ? -1 : dist[i];
                sb.append(value + "\n");
            }
            System.out.println(sb);
        }


    }
}