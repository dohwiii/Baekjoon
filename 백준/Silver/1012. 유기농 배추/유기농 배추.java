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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // 가로길이
            N = Integer.parseInt(st.nextToken());   // 세로길이
            int K = Integer.parseInt(st.nextToken());   // 배추가 심어져 있는 위치 개수
            map = new int[N][M];
            visited = new boolean[N][M];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;  // 배추
            }
            int bugs = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        bugs++;
                    }
                }
            }
            sb.append(bugs + "\n");

        }
        System.out.println(sb);


    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                queue.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
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