
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int area = bfs(i, j);
                    result = Math.max(result, area);
                }
            }
        }
        System.out.println(result);

    }

    public static int bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Pos(x, y, 0));
        visited[x][y] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) { //범위 안이고
                    if (map[nx][ny] == 'W') {
                        continue;
                    }
                    if (!visited[nx][ny] && map[nx][ny] == 'L') { //아직 방문전이고, 육지라면
                        queue.add(new Pos(nx, ny, now.cnt + 1));
                        visited[nx][ny] = true;
                        area = Math.max(area, now.cnt + 1);
                    }
                }
            }
        }
        return area;
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
