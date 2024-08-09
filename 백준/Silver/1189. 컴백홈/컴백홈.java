import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int depth) {
        if (depth > K) {
            return;
        }
        if (depth == K && x == 0 && y == C - 1) {
            ans++;
            return;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == 'T') {
                continue;
            }
            dfs(nx, ny, depth + 1);
        }
        visited[x][y] = false;
    }


}

class Node {
    int node, dist;

    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}