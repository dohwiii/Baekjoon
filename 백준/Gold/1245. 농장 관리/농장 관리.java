
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static boolean[][] visited;
    static boolean isPeak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int mountain = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    isPeak = true;
                    dfs(i, j, map[i][j]);
                    if (isPeak) {
                        mountain++;
                    }
                }
            }
        }
        System.out.println(mountain);


    }

    public static void dfs(int x, int y, int height) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if (height < map[nx][ny]) { //이미 방문한 곳이더라도 더 높은 곳이 있다면 산봉우리가 아님
                isPeak = false;
                continue;
            }
            if (height == map[nx][ny] && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, height);
            }
        }

    }

}