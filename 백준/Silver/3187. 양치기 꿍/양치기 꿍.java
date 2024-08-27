import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static char[][] map;
    static int wolf, sheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int wolfAns = 0;
        int sheepAns = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    wolf = 0;
                    sheep = 0;
                    dfs(i, j);
                    if (sheep > wolf) {
                        sheepAns += sheep;
                    } else {
                        wolfAns += wolf;
                    }
                }
            }
        }

        System.out.println(sheepAns + " " + wolfAns);

    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        if (map[x][y] == 'v') { //늑대
            wolf++;
        } else if (map[x][y] == 'k') {  //양
            sheep++;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#' || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }


}