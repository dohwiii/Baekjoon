import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n][n];

        // INF로 초기화, 자기 자신은 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 간선 입력 (중복 간선은 최소 비용만)
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (c < dist[a][b]) dist[a][b] = c;
        }

        // Floyd-Warshall (불필요한 루프 많이 컷)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue; // i->k 없으면 스킵
                int dik = dist[i][k];
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue; // k->j 없으면 스킵
                    int nd = dik + dist[k][j];
                    if (nd < dist[i][j]) dist[i][j] = nd;
                }
            }
        }

        // 출력: INF면 0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}