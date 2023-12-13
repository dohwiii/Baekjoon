
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static long[][] dist;
    static final long INF = 1_600_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new long[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] == 0) {
                    dist[i][j] = INF;
                }
            }
        }
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= V; j++) {
                    if (i == j || j == k) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        long min = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] == INF) {
                    continue;
                }
                min = Math.min(min, dist[i][j] + dist[j][i]);
            }
        }
        if (min != INF) {
            System.out.println(min);
        } else {
            System.out.println(-1);

        }

    }

}