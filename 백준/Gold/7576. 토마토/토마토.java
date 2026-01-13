import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로
        map = new int[N][M];    // 1: 익은 토마토 / 0: 익지 않은 토마토 / -1: 빈칸
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {   // 토마토
                    queue.offer(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }
        // 토마토가 모두 익어있는 상태
        if (queue.size() == N * M) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int day = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            day++;

            while (size-- > 0) {
                Pos now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] != 0) {
                        continue;
                    }
                    queue.offer(new Pos(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = day;
                }

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day - 2;
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
