import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += dfs(i, j, 0);
            }
        }
        System.out.println(result);

    }

    public static int dfs(int x, int y, int depth) {
        if (x < 0 || x >= N || y < 0 || y >= M) {   //탈출
            return 1;
        }
        if (depth > N * M) {
            return dp[x][y];
        }
        if (visited[x][y]) {
            return dp[x][y];
        }
        visited[x][y] = true;
        dp[x][y] = 0;

        int dir = direction(map[x][y]);
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        dp[x][y] += dfs(nx, ny, depth + 1);

        return dp[x][y];
    }

    public static int direction(char c) {
        switch (c) {
            case 'U':
                return 1;
            case 'R':
                return 2;
            case 'D':
                return 0;
            case 'L':
                return 3;
        }
        return -1;
    }

}
