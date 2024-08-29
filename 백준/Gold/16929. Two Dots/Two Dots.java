import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static char[][] map;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                dfs(i, j, new Pos(i, j), 1);
                if (isPossible) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }

    public static void dfs(int x, int y, Pos start, int cnt) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[start.x][start.y] != map[nx][ny]) {
                continue;
            }
            if (visited[nx][ny]) {
                if (nx == start.x && ny == start.y) {
                    if (cnt % 2 == 0 && cnt >= 4) {
                        isPossible = true;
                        return;
                    }
                }
                continue;
            }

            dfs(nx, ny, start, cnt + 1);
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
