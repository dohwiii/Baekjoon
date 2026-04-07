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
        int INF = 5_000_001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{A, B, C};
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // N-1 반복
        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                int t = edge[2];    // 시간
                if (dist[a] != INF && dist[b] > dist[a] + t) {
                    dist[b] = dist[a] + t;
                }
            }
        }
        boolean hasNegCycle = false;    // 음수 사이클 유무
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int t = edge[2];    // 시간
            if (dist[a] != INF && dist[b] > dist[a] + t) {
                hasNegCycle = true;
                dist[b] = dist[a] + t;
                break;
            }
        }
        if (hasNegCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(dist[i] + "\n");
            }
            System.out.print(sb.toString().trim());
        }


    }

}