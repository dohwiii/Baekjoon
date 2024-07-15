
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
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static String word;

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
        for (int i = 0; i < K; i++) {
            word = br.readLine(); //문자열 (중복가능)
            dp = new int[word.length() + 1][N][M];

            for (int j = 1; j <= word.length(); j++) {
                for (int k = 0; k < N; k++) {
                    Arrays.fill(dp[j][k], -1);
                }
            }
            long sum = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == word.charAt(0)) {
                        sum += dfs(j, k, 1);
                    }
                }
            }
            bw.write(sum + " ");
            bw.write("\n");
        }
        bw.flush();

    }

    public static int dfs(int x, int y, int depth) {
        if (depth == word.length()) {
            return 1;
        }
        if (dp[depth][x][y] != -1) {
            return dp[depth][x][y];
        }

        dp[depth][x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nr = x + dx[i];
            int nc = y + dy[i];

            // 왼쪽
            if (nc < 0 && (nr >= 0 && nr < N)) {
                nc = M - 1;
            }
            // 오른쪽
            else if (nc >= M && (nr >= 0 && nr < N)) {
                nc = 0;
            }
            // 아래
            else if (nr >= N && (nc >= 0 && nc < M)) {
                nr = 0;
            }
            // 위
            else if (nr < 0 && (nc >= 0 && nc < M)) {
                nr = N - 1;
            }
            // 왼좌대각
            else if (nr < 0 && nc < 0) {
                nr = N - 1;
                nc = M - 1;
            }
            // 오른아래대각
            else if (nr >= N && nc >= M) {
                nr = 0;
                nc = 0;
            }

            //왼아래 대각
            else if (nc < 0 && nr >= N) {
                nr = 0;
                nc = M - 1;
            }
            //오른 위 대각
            else if (nc >= M && nr < 0) {
                nr = N - 1;
                nc = 0;
            }
            if (word.charAt(depth) == map[nr][nc]) {
                dp[depth][x][y] += dfs(nr, nc, depth + 1);
            }

        }
        return dp[depth][x][y];
    }


}
