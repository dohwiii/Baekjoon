import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map, broke;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   //부술 수 있는 벽 개수
        map = new int[N][M];
        broke = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int[] b : broke) {
            Arrays.fill(b, 123456789);

        }
        System.out.println(solve(0, 0));

    }

    public static int solve(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(x, y, 1, 0, true));
        visited[x][y][0] = true;
        broke[x][y] = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (map[nx][ny] == 1) { //벽이라면
                    if (now.isRisen) {  //낮이라면
                        if (now.wall < K) {
                            if (!visited[nx][ny][now.wall + 1]) {
                                queue.offer(new Pos(nx, ny, now.cnt + 1, now.wall + 1, !now.isRisen));
                                visited[nx][ny][now.wall + 1] = true;
                            }
                        }
                    } else {    //밤이라면
                        queue.offer(new Pos(now.x, now.y, now.cnt + 1, now.wall, !now.isRisen));    //제자리 걸음
                    }
                }
                else {  //빈 공간
                    if (!visited[nx][ny][now.wall]) {
                        queue.offer(new Pos(nx, ny, now.cnt + 1, now.wall, !now.isRisen));
                        visited[nx][ny][now.wall] = true;
                    }
                }
            }
        }
        return -1;
    }

}

class Pos {
    int x, y, cnt, wall;
    boolean isRisen;

    public Pos(int x, int y, int cnt, int wall, boolean isRisen) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.wall = wall;
        this.isRisen = isRisen;
    }
}