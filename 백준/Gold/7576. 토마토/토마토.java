
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> tomatoQueue = new ArrayDeque<>();

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
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    tomatoQueue.offer(new Pos(i, j, 0));

                }
            }
        }
        System.out.println(tomato());

    }
    // 1 - 익은 토마토
    // 0 - 익지 않은 토마토
    // -1 - 토마토 없음
    public static int tomato() {
        int max = 0;

        while (!tomatoQueue.isEmpty()) {
            Pos now = tomatoQueue.poll();
            max = Math.max(max, now.day);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        tomatoQueue.offer(new Pos(nx, ny, now.day + 1));
                        visited[nx][ny] = true;
                        map[nx][ny] = now.day + 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    max = -1;
                    break;
                }
            }
            if (max == -1) {
                break;
            }
        }
        return max;
    }
}

class Pos {
    int x, y, day;

    public Pos(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}