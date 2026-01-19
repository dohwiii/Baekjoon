import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        char[][] bMap = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                bMap[i][j] = c;
                if (c == 'G') {
                    bMap[i][j] = 'R';
                }
            }
        }
        int area = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    area++;
                    dfs(i, j, map);
                }

            }
        }
        visited = new boolean[N][N];
        int bArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bArea++;
                    dfs(i, j, bMap);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(area + " " + bArea);
        System.out.println(sb);

    }

    private static void dfs(int x, int y, char[][] temp) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        char color = temp[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }
            if (color != temp[nx][ny]) {
                continue;
            }
            dfs(nx, ny, temp);

        }
    }

}
