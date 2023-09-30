import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int result;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //가로
        M = Integer.parseInt(st.nextToken()); //세로
        K = Integer.parseInt(st.nextToken()); //부수는 벽의 개수
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        if (isPossible) {
            System.out.println(result);

        } else {
            System.out.println(-1);
        }


    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y, 0, 1, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                isPossible = true;
                result = now.cnt;
                return;
            }
            if (now.wallCnt > K) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) { //빈칸
                        if (!now.alreadyBreak && !visited[nx][ny][0]) { //벽 부신적 없음
                            queue.add(new Pos(nx, ny, now.wallCnt, now.cnt + 1, now.alreadyBreak));
                            visited[nx][ny][0] = true;
                        }
                        else if (now.alreadyBreak && !visited[nx][ny][now.wallCnt]) { //벽 부신적 있음
                            queue.add(new Pos(nx, ny, now.wallCnt, now.cnt + 1, now.alreadyBreak));
                            visited[nx][ny][now.wallCnt] = true;
                        }
                    } 
                    else if (map[nx][ny] == 1) { //벽
                        if (now.wallCnt + 1 <= K) {
                            if (!visited[nx][ny][now.wallCnt + 1]) {
                                queue.add(new Pos(nx, ny, now.wallCnt + 1, now.cnt + 1, true));
                                visited[nx][ny][now.wallCnt + 1] = true;
                            }
                        }

                    }

                }
            }

        }
    }
}

class Pos {
    int x, y, wallCnt, cnt;
    boolean alreadyBreak;

    public Pos(int x, int y, int wallCnt, int cnt, boolean alreadyBreak) {
        this.x = x;
        this.y = y;
        this.wallCnt = wallCnt;
        this.cnt = cnt;
        this.alreadyBreak = alreadyBreak;
    }

}