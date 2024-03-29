import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; //동 서 북 남
    static int[] dy = {1, -1, 0, 0,};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);

    }

    public static void dfs(int x, int y, int sum, int cnt) {

        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny])
                {
                    if (cnt == 2) {
                        visited[nx][ny] = true;
                        dfs(x, y, sum + map[nx][ny], cnt + 1);
                        visited[nx][ny] = false;

                    }
                    visited[nx][ny] = true;
                    dfs(nx, ny, sum + map[nx][ny], cnt + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}