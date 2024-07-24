import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] dp;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxLen = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        dp = new int[R][C];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            Arrays.fill(dp[i], -1);
        }

        dfs(0, 0, 1, visited);
        bw.write(maxLen + "\n");
        bw.flush();
    }

    public static void dfs(int x, int y, int count, boolean[] visited) {
        visited[map[x][y] - 'A'] = true;
        maxLen = Math.max(maxLen, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[map[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1, visited);
            }
        }

        visited[map[x][y] - 'A'] = false; // 재귀 호출이 끝나면 원래 상태로 복구
    }
}
