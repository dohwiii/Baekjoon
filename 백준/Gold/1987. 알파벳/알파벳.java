import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxLen = 0;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1 << map[0][0] - 'A', 1);
        bw.write(maxLen + "\n");
        bw.flush();
    }

    public static void dfs(int x, int y, int bit, int count) {
        if (visited[x][y] == bit) {
            return;
        }
        visited[x][y] = bit;
        maxLen = Math.max(maxLen, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || (bit & (1 << map[nx][ny] - 'A')) != 0) {
                continue;
            }
            dfs(nx, ny, bit | (1 << map[nx][ny] - 'A'), count + 1);

        }

    }
}
