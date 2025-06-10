import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < R; i++) {
            if (map[i][0] == '.' && !visited[i][0]) {
                if (dfs(i, 0)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    public static boolean dfs(int x, int y) {
        if (y == C - 1) {   //도착 완료
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == 'x') {
                continue;
            }
            visited[nx][ny] = true;
            if (dfs(nx, ny)) {
                return true;
            }
        }
        return false;
    }

}