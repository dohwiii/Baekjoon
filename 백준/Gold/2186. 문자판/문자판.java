import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] map;
    static int[][][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String word;
    static long result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        word = br.readLine();
        dp = new int[N][M][word.length()];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == word.charAt(0)) {
                    result += dfs(i, j, 1);
                }
            }
        }

        bw.write(Long.toString(result));
        bw.flush();
    }

    public static int dfs(int x, int y, int depth) {
        if (depth == word.length()) {
            return 1;
        }

        if (dp[x][y][depth] != -1) {
            return dp[x][y][depth];
        }

        dp[x][y][depth] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    break;  // 범위를 벗어나면 더 이상 진행하지 않음
                }

                if (map[nx][ny] == word.charAt(depth)) {
                    dp[x][y][depth] += dfs(nx, ny, depth + 1);
                }
            }
        }

        return dp[x][y][depth];
    }
}
