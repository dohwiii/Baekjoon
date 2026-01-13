import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로
        map = new int[N][M];    // 1: 익은 토마토 / 0: 익지 않은 토마토 / -1: 빈칸
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();
        int unripe = 0;     // 0의 개수
        int maxDay = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;

                if (v == 1) {   // 토마토
                    queue.offer(new int[]{i, j});
                } else if (v == 0) {
                    unripe++;
                }
            }
        }
        // 토마토가 모두 익어있는 상태
        if (unripe == 0) {
            System.out.println(0);
            return;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] now = queue.poll();
                int curDay = map[now[0]][now[1]];

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] != 0) {
                        continue;
                    }
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = curDay + 1;
                    unripe--;
                    maxDay = Math.max(maxDay, map[nx][ny]);
                }
            }
        }
        if (unripe > 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(maxDay - 1);
        }

    }

}