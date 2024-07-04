import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int minHeight, N, maxHeight;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        minHeight = 101;
        maxHeight = 0;
        int maxArea = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = minHeight > map[i][j] ? map[i][j] : minHeight;
                maxHeight = maxHeight < map[i][j] ? map[i][j] : maxHeight;
            }
        }


        while (minHeight < maxHeight) {
            visited = new boolean[N][N];
            int[][] cloneMap = new int[N][N];
            int area = 0;

            for (int i = 0; i < N; i++) {   //깊은 복사
                cloneMap[i] = map[i].clone();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cloneMap[i][j] -= minHeight;
                    if (cloneMap[i][j] < 0) {
                        cloneMap[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cloneMap[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j, cloneMap);
                        area++;
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
            minHeight++;
        }

        System.out.println(maxArea);
    }

    public static void bfs(int x, int y, int[][] cloneMap) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && cloneMap[nx][ny] != 0) {
                        queue.offer(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}