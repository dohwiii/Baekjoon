import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map, dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static final int INF = 140_626;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {   // 종료
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

            // 최소 금액으로 이동 (N-1, N-1)
            solve(0, 0);
            sb.append("Problem " + T + ": " + dp[N - 1][N - 1]);
            sb.append("\n");
            T++;
        }
        System.out.println(sb);


    }

    private static void solve(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[0][0] = map[0][0];
        pq.offer(new Node(x, y, dp[x][y]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dp[now.x][now.y] < now.dist) {
                continue;
            }
            if (now.x == N - 1 && now.y == N - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (dp[nx][ny] > dp[now.x][now.y] + map[nx][ny]) {
                    dp[nx][ny] = dp[now.x][now.y] + map[nx][ny];
                    pq.offer(new Node(nx, ny, dp[nx][ny]));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}