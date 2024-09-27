
import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> tomatos = new ArrayDeque<>();
    static boolean[][] visited;
    static boolean isRipen = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {   //익은 토마토
                    tomatos.offer(new Pos(i, j));
                }
            }
        }
        // 모든 토마토가 익어있는 상태
        if (tomatos.size() == M * N) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    public static int bfs() {
        int day = 0;

        while (!tomatos.isEmpty()) {
            int size = tomatos.size();

            while (size-- > 0) {
                Pos now = tomatos.poll();
                visited[now.x][now.y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] != 0) {
                        continue;
                    }
                    map[nx][ny] = 1;
                    visited[nx][ny] = true;
                    tomatos.offer(new Pos(nx, ny));
                }
            }
            day++;  //하루 지남
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    isRipen = false;
                    break;
                }
            }
            if (!isRipen) {
                break;
            }
        }
        if (isRipen) {
            return day - 1;
        } else {
            return -1;
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