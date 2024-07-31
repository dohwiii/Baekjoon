
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int ans;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int plankCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    plankCount++;
                }
            }
        }
        System.out.println(plankCount);

    }

    public static void dfs(int x, int y, char type) {
        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] != type) {
            return;
        }
        visited[x][y] = true;

        if (type == '-') {
            dfs(x, y + 1, type);
            dfs(x, y - 1, type);
        } else if (type == '|') {
            dfs(x + 1, y, type);
            dfs(x - 1, y, type);
        }


    }

}