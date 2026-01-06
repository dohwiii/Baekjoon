import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        result = 10_000;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }
//        dfs(0, 0, 1);
        bfs(0, 0);
        System.out.println(result);

    }

    public static void dfs(int x, int y, int depth) {
        if (x == N - 1 && y == M - 1) {
            result = Math.min(result, depth);
            return;
        }
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return;
        }
        if (visited[x][y] || arr[x][y] == '0') {
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == '0') {
                continue;
            }
            dfs(nx, ny, depth + 1);
        }
        visited[x][y] = false;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == N - 1 && now[1] == M - 1) {
                result = now[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == '0') {
                    continue;
                }
                queue.offer(new int[]{nx, ny, now[2] + 1});
                visited[nx][ny] = true;
            }

        }
    }
}
