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

    // 방문 배열 재사용용 (stamp 기법)
    static int[][] visited;
    static int stamp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) virusList.add(new int[]{i, j});
                else if (map[i][j] == 0) emptyList.add(new int[]{i, j});
            }
        }

        // visited는 딱 한 번만 생성
        visited = new int[N][M];

        buildWall(0, 0);
        System.out.println(maxSafeZone);
    }

    private static void buildWall(int wall, int start) {
        if (wall == 3) {
            bfsWithStamp();
            return;
        }
        for (int i = start; i < emptyList.size(); i++) {
            int[] pos = emptyList.get(i);
            int x = pos[0], y = pos[1];

            if (map[x][y] != 0) continue;

            map[x][y] = 1;
            buildWall(wall + 1, i + 1);
            map[x][y] = 0;
        }
    }

    private static void bfsWithStamp() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 이번 BFS에서 사용할 stamp 값
        int curStamp = stamp++;

        for (int[] v : virusList) {
            queue.offer(v);
            visited[v[0]][v[1]] = curStamp;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] != 0) continue;              // 빈 칸만 감염
                if (visited[nx][ny] == curStamp) continue;   // 이번 BFS에서 이미 방문

                visited[nx][ny] = curStamp;
                queue.offer(new int[]{nx, ny});
            }
        }

        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visited[i][j] != curStamp) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }
}
