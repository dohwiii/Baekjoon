import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int result = 0;

        if (K != 0) {
            int row = (K - 1) / M;
            int col = (K - 1) % M;
            int r1 = dfs(0, 0, row, col);
            for (int[] d : dp) {
                Arrays.fill(d, -1);
            }
            int r2 = dfs(row, col, N - 1, M - 1);
            result = r1 * r2;
        }
        else {
            result = dfs(0, 0, N - 1, M - 1);
        }
        System.out.println(result);



    }

    public static int dfs(int x, int y, int tx, int ty) {
        if (x == tx && y == ty) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            dp[x][y] += dfs(nx, ny, tx, ty);
        }
        return dp[x][y];
    }
}
