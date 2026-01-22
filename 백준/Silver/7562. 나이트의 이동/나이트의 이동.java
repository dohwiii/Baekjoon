import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] pos = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] destination = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            sb.append(bfs(pos[0], pos[1], destination[0], destination[1]));
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static int bfs(int x, int y, int destX, int destY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == destX && now[1] == destY) {
                return now[2];
            }
            for (int dir = 0; dir < 8; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, now[2] + 1});

            }
        }
        return 0;

    }

}
