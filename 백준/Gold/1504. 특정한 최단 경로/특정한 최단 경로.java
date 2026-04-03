import java.io.*;
import java.util.*;

public class Main {
    static int N, E, u, v;
    static int[][] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());   // 거리
            // 양방향
            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        // 1번 ~ N번 이동할 때 반드시 두 정점을 거쳐야 함
        // 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다 -> 하지만 최단 경로

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {  // 중간 다리
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }


                }
            }
        }
        long path1 = Long.MAX_VALUE;  // 불가능이라고 일단 가정
        long path2 = Long.MAX_VALUE;
        int MAX = Integer.MAX_VALUE;

        // path1이 가능할 때만 계산
        if (dist[1][u] != MAX && dist[u][v] != MAX && dist[v][N] != MAX) {
            path1 = (long)dist[1][u] + dist[u][v] + dist[v][N];
        }

        // path2가 가능할 때만 계산
        if (dist[1][v] != MAX && dist[v][u] != MAX && dist[u][N] != MAX) {
            path2 = (long)dist[1][v] + dist[v][u] + dist[u][N];
        }

        // 둘 다 불가능하면 -1, 아니면 작은 값
        long result = Math.min(path1, path2);
        System.out.println(result == Long.MAX_VALUE ? -1 : result);

    }
}