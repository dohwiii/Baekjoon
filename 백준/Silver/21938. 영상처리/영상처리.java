
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] map;
    static int[][] newMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M * 3 + 1];
        visited = new boolean[N][M];
        newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M * 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T = Integer.parseInt(br.readLine());    //경계값

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 1; j <= M * 3; j++) {
                sum += map[i][j];
                if (j % 3 == 0) {
                    int avg = sum / 3;
                    if (avg >= T) {
                        newMap[i][j / 3 - 1] = 255;
                    } else {
                        newMap[i][j / 3 - 1] = 0;
                    }
                    sum = 0;    //초기화
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && newMap[i][j] == 255) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || newMap[nx][ny] != 255 || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }

}