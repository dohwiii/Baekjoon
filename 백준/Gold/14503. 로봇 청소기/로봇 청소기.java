import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        int nowDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(nowX, nowY, nowDir);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int dir) {
        int wallCount = 0;
        int cleanCount = 0;

        if (map[x][y] == 0) {
            map[x][y] = 2;
            result++;
        }
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M)
            {
                if (map[nx][ny] == 0) //청소되지 않은 칸
                {
                    dfs(nx, ny, dir);
                    return;
                }
            }
        }
        int nnx = 0;
        int nny = 0;
        if (dir == 0) {
            nnx = x + dx[2];
            nny = y + dy[2];
        } else if (dir == 1) {
            nnx = x + dx[3];
            nny = y + dy[3];
        } else if (dir == 2) {
            nnx = x + dx[0];
            nny = y + dy[0];
        } else if (dir == 3) {
            nnx = x + dx[1];
            nny = y + dy[1];
        }
        if (map[nnx][nny] == 1) {
            return;
        }
        if (nnx >= 0 && nnx < N && nny >= 0 && nny < M) {
            dfs(nnx, nny, dir);
        }
    }
}