import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int powerW = 0;  // 흰색 병사의 총 위력
        int powerB = 0;  // 파란색 병사의 총 위력

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int soldierCount = dfs(i, j, map[i][j]);
                    int power = soldierCount * soldierCount;
                    if (map[i][j] == 'W') {
                        powerW += power;
                    } else {
                        powerB += power;
                    }
                }
            }
        }

        bw.write(powerW + " " + powerB);
        bw.flush();
        bw.close();
    }

    public static int dfs(int x, int y, char flag) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == flag && !visited[nx][ny]) {
                count += dfs(nx, ny, flag);
            }
        }

        return count;
    }
}
