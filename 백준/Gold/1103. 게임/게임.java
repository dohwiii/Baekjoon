import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = dfs(0, 0);
        bw.write(result + " ");
        bw.flush();


    }

    public static int dfs(int x, int y) {
        if (visited[x][y]) {
            return -1;  // 무한 루프 감지
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        visited[x][y] = true;
        int maxMoves = 1;
        int num = map[x][y] - '0';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'H') {
                int moves = dfs(nx, ny);
                if (moves == -1) {
                    visited[x][y] = false;
                    return -1;  // 무한 루프 감지
                }
                maxMoves = Math.max(maxMoves, moves + 1);
            }
        }

        visited[x][y] = false;
        dp[x][y] = maxMoves;
        return dp[x][y];
    }

}
