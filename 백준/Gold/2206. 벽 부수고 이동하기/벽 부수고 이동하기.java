import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(0, 0, 0, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (now.isWallUsed && map[nx][ny] == 1) {   //벽을 이미 사용했는데 벽을 만난 경우
                    continue;
                }

                //벽이라면 1
                if (map[nx][ny] == 1) {
                    if (!now.isWallUsed && !visited[nx][ny][1]) {  //벽을 아직 사용안함
                        queue.offer(new Pos(nx, ny, now.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else { //빈 공간 0
                    if (now.isWallUsed) {   //이미 벽 사용함
                        if (!visited[nx][ny][1]) {
                            queue.offer(new Pos(nx, ny, now.cnt + 1, now.isWallUsed));
                            visited[nx][ny][1] = true;
                        }
                    } else {    //아직 벽 사용 안함
                        if (!visited[nx][ny][0]) {
                            queue.offer(new Pos(nx, ny, now.cnt + 1, now.isWallUsed));
                            visited[nx][ny][0] = true;
                        }
                    }

                }
            }
        }
        return -1;
    }

}

class Pos {
    int x, y, cnt;
    boolean isWallUsed;

    public Pos(int x, int y, int cnt, boolean isWallUsed) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.isWallUsed = isWallUsed;
    }
}