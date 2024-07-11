import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;
    static int bridge = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int index = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {   //육지
                    findIsland(i, j, index++);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][N];
                    makeBridge(i, j);
                }
            }
        }
        System.out.println(bridge);

    }

    public static void findIsland(int x, int y, int index) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        map[x][y] = index;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0) {
                    continue;
                }
                if (map[nx][ny] == 1) { //바다
                    queue.offer(new Pos(nx, ny));
                    map[nx][ny] = index;
                }
            }
        }

    }

    public static void makeBridge(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y, 0));
        visited[x][y] = true;
        int nowNum = map[x][y];

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == nowNum || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) { //바다
                    queue.offer(new Pos(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                } else {
                    if (map[nx][ny] != nowNum) { //새로운 섬
                        bridge = Math.min(bridge, now.cnt);
                    }
                }

            }
        }
    }

}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}