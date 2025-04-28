import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map, dp;
    static final int INF = 200000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = INF;
                }
            }
            dp[0][0] = map[0][0];
            PriorityQueue<Pos> queue = new PriorityQueue<>();
            queue.offer(new Pos(0, 0, map[0][0]));

            while (!queue.isEmpty()) {
                Pos now = queue.poll();
                if (dp[now.x][now.y] < now.cost) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (dp[nx][ny] > dp[now.x][now.y] + map[nx][ny]) {
                        dp[nx][ny] = dp[now.x][now.y] + map[nx][ny];
                        queue.offer(new Pos(nx, ny, dp[nx][ny]));
                    }
                }
            }
            sb.append("Problem ").append(index + ": ");
            sb.append(dp[N - 1][N - 1] + "\n");
            index++;
        }
        System.out.println(sb.toString());

    }

    static class Pos implements Comparable<Pos> {
        int x, y, cost;

        public Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost;
        }
    }
}