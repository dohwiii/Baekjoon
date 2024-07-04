import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') { //육지라면
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);

    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            max = Math.max(max, now.cnt);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 'L') {
                    queue.offer(new Pos(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }


    }
}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}