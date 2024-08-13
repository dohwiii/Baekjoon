import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;
    static boolean[][] visited;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0) {
                if (!visited[0][i] && !isPossible) {
                    dfs(0, i);
                }
            }
        }
        if (isPossible) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

    public static void dfs(int x, int y) {
        if (x == M - 1) {
            isPossible = true;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == 1 || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
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