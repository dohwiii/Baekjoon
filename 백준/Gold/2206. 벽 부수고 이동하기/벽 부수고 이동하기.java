import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        bfs();
        if (dist[N - 1][M - 1][0] != -1 && dist[N - 1][M - 1][1] != -1) {
            System.out.println(Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]));
        } else if (dist[N - 1][M - 1][0] != -1) {
            System.out.println(dist[N - 1][M - 1][0]);
        } else {
            System.out.println(dist[N - 1][M - 1][1]);

        }

    }

    private static void bfs() {
        Queue<Root> queue = new ArrayDeque<>();
        queue.offer(new Root(0, 0, 0));
        dist[0][0][0] = 1; // 시작 지점

        while (!queue.isEmpty()) {
            Root now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == '1') { // 벽
                    if (now.wall < 1 && dist[nx][ny][now.wall + 1] == -1) {
                        queue.offer(new Root(nx, ny, now.wall +1));   // 부수기
                        dist[nx][ny][now.wall + 1] = dist[now.x][now.y][now.wall] + 1;
                    }
                } else {
                    // 이동가능
                    if (dist[nx][ny][now.wall] == -1) {
                        queue.offer(new Root(nx, ny, now.wall));
                        dist[nx][ny][now.wall] = dist[now.x][now.y][now.wall] + 1;
                    }
                }

            }
        }
    }

    static class Root {
        int x, y, wall;

        public Root(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

}
