import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int areaSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            int ltx = Math.abs(M - 1 - ly);
            int lty = lx;
            int rtx = Math.abs(M - ry);
            int rty = Math.abs(rx - 1);

            for (int x = rtx; x <= ltx; x++) {
                for (int y = lty; y <= rty; y++) {
                    visited[x][y] = true;
                }
            }
        }
        int area = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    area++;
                    areaSize = 0;
                    dfs(i, j);
                    list.add(areaSize);
                }
            }
        }
        Collections.sort(list);
        sb.append(area + "\n");
        for (int n : list) {
            sb.append(n + " ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        areaSize++;
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }
}