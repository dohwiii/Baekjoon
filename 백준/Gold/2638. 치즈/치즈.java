import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;

        while (true) {
            int[][] temp = new int[N][M];
            visited = new boolean[N][M];
            dp = new int[N][M];

            for (int i = 0; i < N; i++) {
                temp[i] = map[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == 0 || i == N - 1 || j == 0 || j == M - 1) { //맨 가장자리
                        if (temp[i][j] == 0) {
                            air(i, j, temp);
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && temp[i][j] == 1) {
                        bfs(i, j, temp);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dp[i][j] >= 2) {
                        map[i][j] = 0;  //녹음
                    }
                }
            }
            hour++;

            boolean isMelt = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        isMelt = false;
                    }
                }
            }
            if (isMelt) {
                break;
            }

        }
        bw.write(hour + " ");
        bw.flush();

    }

    public static void air(int x, int y, int[][] temp) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        temp[x][y] = 3;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || temp[nx][ny] == 3) {
                    continue;
                }
                if (temp[nx][ny] == 0) { //공기
                    queue.offer(new Pos(nx, ny));
                    temp[nx][ny] = 3;
                }
            }
        }
    }

    public static void bfs(int x, int y, int[][] temp) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }
                if (temp[nx][ny] == 3) { //공기 중 접촉
                    cnt++;
                }
                else {  //치즈
                    queue.offer(new Pos(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            dp[now.x][now.y] = cnt;
        }
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}