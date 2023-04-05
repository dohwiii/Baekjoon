import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;

        while (true)
        {
            int count = 0;
            boolean melt = true;
            visited = new boolean[N][M];
            water = new int[N][M];

            //인접한 바닷물의 개수 water 배열 채우기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && iceberg[i][j] != 0) {
                        countAndSubtract(i, j);
                        count++;
                    }
                }
            }
            if (count >= 2) {
                System.out.println(year);
                break;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (iceberg[i][j] - water[i][j] < 0) {
                        iceberg[i][j] = 0;
                    }
                    else
                        iceberg[i][j] = iceberg[i][j] - water[i][j];
                }
            }
            year++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (iceberg[i][j] != 0) {
                        melt = false;
                    }
                }
            }
            if (melt && count < 2) {
                System.out.println(0);
                break;
            }

        }
    }
    public static void countAndSubtract(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Pos(x, y));

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            int waterCount = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (iceberg[nx][ny] == 0) {
                            waterCount++;
                        } else {
                            queue.add(new Pos(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            water[now.x][now.y] = waterCount;
        }
    }


//    public static void BFS(int x, int y) {
//        Queue<Pos> queue = new LinkedList<>();
//        visited[x][y] = true;
//        queue.add(new Pos(x, y));
//
//        while (!queue.isEmpty()) {
//            Pos now = queue.poll();
//            int count = 0;
//
//            for (int i = 0; i < 4; i++)
//            {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
//                    if (!visited[nx][ny] && iceberg[nx][ny] == 0) {
//                        count++;
//                    }
//                }
//            }
//            water[now.x][now.y] = count;
//        }
//    }
//    public static void chunk(int x, int y) {
//        Queue<Pos> queue = new LinkedList<>();
//        visited[x][y] = true;
//        queue.add(new Pos(x, y));
//
//        while (!queue.isEmpty()) {
//            Pos now = queue.poll();
//
//            for (int i = 0; i < 4; i++)
//            {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
//                    if (!visited[nx][ny] && iceberg[nx][ny] != 0) {
//                        queue.add(new Pos(nx, ny));
//                        visited[nx][ny] = true;
//                    }
//                }
//            }
//        }
//    }
}

class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}