import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    static boolean[][] visited;
    static int[][] map;
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
                if (map[i][j] != 0 && !visited[i][j]) {
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
            if (map[nx][ny] > height) {
                isPeak = false;
            }
            if (map[nx][ny] == height && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, height);
            }

        }
    }


}