import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static Queue<Pos> jihoon = new ArrayDeque<>();
    static Queue<Pos> fire = new ArrayDeque<>();
    static boolean[][] visitedJihoon;
    static boolean[][] visitedFire;
    static boolean isPossible;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedJihoon = new boolean[R][C];
        visitedFire = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') { //지훈
                    jihoon.offer(new Pos(i, j, 1));
                } else if (map[i][j] == 'F') {    //불
                    fire.offer(new Pos(i, j));
                }
            }
        }
        solve();
        if (isPossible) {
            System.out.println(answer);
        }
        else {
            System.out.println("IMPOSSIBLE");
        }

        br.close();

    }

    private static void solve() {
        while (!jihoon.isEmpty() || !fire.isEmpty()) {
            int jSize = jihoon.size();
            int fSize = fire.size();

            //불 확산
            while (fSize-- > 0) {
                Pos now = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#' || visitedFire[nx][ny]) {
                        continue;
                    }
                    visitedFire[nx][ny] = true;
                    fire.offer(new Pos(nx, ny));
                }
            }
            //지훈 이동
            while (jSize-- > 0) {
                Pos now = jihoon.poll();
                if (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1) {
                    isPossible = true;
                    answer = now.cnt;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    //벽이거나 불 만나면 가면 안됨
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] != '.' || visitedJihoon[nx][ny] || visitedFire[nx][ny]) {
                        continue;
                    }
                    visitedJihoon[nx][ny] = true;
                    jihoon.offer(new Pos(nx, ny, now.cnt + 1));
                }
            }

        }
    }

    static class Pos {
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
}
