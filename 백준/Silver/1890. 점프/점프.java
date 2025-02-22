import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (long[] d : dp) {
            Arrays.fill(d, -1);
        }
        solve(0, 0);
        System.out.println(dp[0][0]);

    }

    public static long solve(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        int step = map[x][y];   //갈 수 있는 거리

        for (int i = 0; i < 2; i++) {   //오른쪽 or 아래
            int nx = x + dx[i] * step;
            int ny = y + dy[i] * step;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            dp[x][y] += solve(nx, ny);

        }
        return dp[x][y];
    }
}
