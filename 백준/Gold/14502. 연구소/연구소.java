import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int maxSafeZone = 0;
    static List<int[]> virusList = new ArrayList<>();
    static List<int[]> emptyList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 세로
        M = Integer.parseInt(st.nextToken());   // 가로
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    emptyList.add(new int[]{i, j});
                }

            }
        }
        buildWall(0, 0);
        System.out.println(maxSafeZone);


    }

    private static void buildWall(int wall, int start) {
        if (wall == 3) {   // 3개의 벽 완성
            bfs();
            return;
        }
        for (int i = start; i < emptyList.size(); i++) {
            int[] pos = emptyList.get(i);
            int x = pos[0], y = pos[1];

            if (map[x][y] != 0) continue; // 혹시 이전 선택으로 바뀌었을 수 있으니 안전장치

            map[x][y] = 1;
            buildWall(wall + 1, i + 1);
            map[x][y] = 0;  // 원복
        }


    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        for (int[] v : virusList) {
            queue.offer(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0 || visited[nx][ny]) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safeZone);

    }

}
